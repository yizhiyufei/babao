package com.babao.freamewoke.shiro.web.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;
/**
 * 角色授权拦截器
 * 1、首先判断用户有没有任意角色，如果没有返回false，将到onAccessDenied进行处理
 * 2、如果用户没有角色，接着判断用户有没有登录，如果没有登录先重定向到登录；
 * 3、如果用户没有角色且设置了未授权页面，那么重定向到未授权页面，否则返回401错误码
 * @author yizhiyufei
 *
 */
public class AnyRolesFilter extends AccessControlFilter {
	private String unauthorizedUrl = "/unauthorized.jsp";//未授权页面
	private String loginUrl = "/login.jsp";
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		// TODO Auto-generated method stub
		String [] roles = (String[]) mappedValue;
		if(roles == null)
			return true;//如果没有设置角色参数，默认成功
		for(String role : roles) {
			if(getSubject(request,response).hasRole(role))
				return true;
		}
		return false;//跳到onAccessDenied处理
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Subject subject = getSubject(request, response);
		//表示没有登录，重定向到登录页面
		if(subject.getPrincipal() == null) {
			saveRequest(request);
			WebUtils.issueRedirect(request, response, loginUrl);
		}else {
			//如果有未授权页面跳过去
			if(StringUtils.hasText(unauthorizedUrl)) {
				WebUtils.issueRedirect(request, response, loginUrl);
			}else {
				//否则返回401未授权状态码
				WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
			}
		}
		return false;
	}

}
