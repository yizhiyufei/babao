package com.babao.freamewoke.shiro.web.filter;

import com.babao.system.domain.pojo.Member;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 并发登录拦截器
 * @author yizhiyufei
 *
 */
@Slf4j
public class KickoutSessionControlFilter extends AccessControlFilter {

	private String kickoutUrl; //踢出后到的地址
    private boolean kickoutAfter = false; //踢出之前登录的/之后登录的用户 默认踢出之前登录的用户
    private int maxSession = 1; //同一个帐号最大会话数 默认1
    private Cache<String, Deque<Serializable>> kickoutSession;
    
    @Autowired
    @Qualifier("webSessionManager")
    private DefaultWebSessionManager defaultWebSessionManager;
    @Autowired
	private CacheManager cacheManager;  
    
    @PostConstruct
	public void init() {
    	kickoutSession = cacheManager.getCache("kickoutSession");
	}

    public void setKickoutUrl(String kickoutUrl) {
        this.kickoutUrl = kickoutUrl;
    }

    public void setKickoutAfter(boolean kickoutAfter) {
        this.kickoutAfter = kickoutAfter;
    }

    public void setMaxSession(int maxSession) {
        this.maxSession = maxSession;
    }

    /**
     * 如果已登录或者记住我进行拦截，否则放行
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
    	Subject subject = getSubject(request, response);
        if(subject.isAuthenticated() || subject.isRemembered()) {
            return false;
        }else {
        	return true;
        }
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);       
        Member member = (Member) subject.getPrincipal();
        Session session = subject.getSession();       
        String username = member.getMemberAccount();
        Serializable sessionId = session.getId();
       
        //TODO 同步控制
        Deque<Serializable> deque = kickoutSession.get(username);
        if(deque == null) {
            deque = new LinkedList<Serializable>();
            kickoutSession.put(username, deque);
        }
        //如果队列里没有此sessionId，且用户没有被踢出；放入队列
        if(!deque.contains(sessionId)) {
            deque.push(sessionId);
        }
        //如果队列里的sessionId数超出最大会话数，开始踢人
        while(deque.size() > maxSession) {
            Serializable kickoutSessionId = null;
            if(kickoutAfter) { //如果踢出后者
                kickoutSessionId = deque.removeFirst();
            } else { //否则踢出前者
                kickoutSessionId = deque.removeLast();
            }
            try {
            	Session kickoutSession = defaultWebSessionManager.getSession(new DefaultSessionKey(kickoutSessionId));
                if(kickoutSession != null) {
                    //设置会话的kickout属性表示踢出了
                    kickoutSession.setAttribute("kickout", true);            	
                }
            } catch (Exception e) {//ignore exception
            	log.debug(e.getMessage());
            }
        }
 
        //如果被踢出了，直接退出，重定向到踢出后的地址
        if (session.getAttribute("kickout") != null) {
            //会话被踢出了
            try {
                subject.logout();
                System.out.println("已经踢出了");
            } catch (Exception e) { //ignore
            }
            saveRequest(request);
            WebUtils.issueRedirect(request, response, kickoutUrl);
            return false;
        }

        return true;
    }

}
