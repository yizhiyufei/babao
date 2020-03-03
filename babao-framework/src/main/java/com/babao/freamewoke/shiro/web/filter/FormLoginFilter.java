package com.babao.freamewoke.shiro.web.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;
/**
 * 表单拦截器
 * 1、首先判断是否已经登录过了，如果已经锅炉过了继续拦截器链即可；
 * 2、如果没有登录，看看是否是登录请求，如果是get方法的登录页面请求，则继续拦截器链（到请求页面），
 * 3、如果是post方法的登录页面表单提交请求，则收集用户名、密码登录即可，如果失败了保存错误消息到"shiroLoginFailure"并返回登录页面；
 * 4、如果登录成功了，且之前有保存的请求，则重定向到之前的这个请求，否则到默认的成功页面。
 * @author yizhiyufei
 *
 */
public class FormLoginFilter extends PathMatchingFilter {
	private String loginUrl = "/login.jsp";
	private String successUrl = "/";
	@Override
	protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		// TODO Auto-generated method stub
		if(SecurityUtils.getSubject().isAuthenticated())
			return true;//登录状态
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		if(isLoginRequest(req)) {
			//判断HTTP请求方法是否是post方法
			if("post".equalsIgnoreCase(req.getMethod())) {//form表单提交
				boolean loginSuccess = login(req);
				if(loginSuccess) { 
					return redirectToSuccessUrl(req,resp);
				}
			}
			return true;//继续过滤器链
		}else {//保存当前地址并重定向到登录界面
			saveRequestAndRedirectToLogin(req,resp);
			return false;
		}
	}
	/**
	 * 重定向到新的登录url
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void saveRequestAndRedirectToLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		WebUtils.saveRequest(req);
		WebUtils.issueRedirect(req, resp, loginUrl);
	}
	/**
	 * 重定向到成功页面url
	 * @param req
	 * @param resp
	 * @return
	 * @throws IOException
	 */
	private boolean redirectToSuccessUrl(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		WebUtils.redirectToSavedRequest(req, resp, successUrl);
		return false;
	}
	private boolean login(HttpServletRequest req) {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		try {
			SecurityUtils.getSubject().login(new UsernamePasswordToken(username,password));
		}catch(Exception e) {
			req.setAttribute("shiroLoginFailure", e.getClass());
			return false;
		}
		return true;
	}
	//判断登录url和请求url的path是否相同
	private boolean isLoginRequest(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return pathsMatch(loginUrl,WebUtils.getPathWithinApplication(req));
	}
}
