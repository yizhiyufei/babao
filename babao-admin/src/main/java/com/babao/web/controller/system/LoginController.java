package com.babao.web.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.babao.common.croe.controller.BaseController;
import com.babao.common.croe.domain.AjaxResult;
import com.babao.freamewoke.shiro.service.LoginService;
import com.babao.system.domain.Member;
import com.babao.system.service.MemberService;

import lombok.extern.slf4j.Slf4j;

/**
 * 登录
 * 
 * @author yizhiyufei
 *
 */
@Controller
@Slf4j
public class LoginController extends BaseController{
	
	@Autowired
	private MemberService memberService;
	@Autowired
	LoginService loginService;
	
	@GetMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response) {

		return "login";
	}

	@PostMapping("/login")
	@ResponseBody
	public AjaxResult ajaxLogin(String username, String password, Boolean rememberMe) {
		UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return success();		 
		} catch (AuthenticationException e) {
			return error(e.getMessage());
		}
	}
	
	@GetMapping("/register")
	public String register(HttpServletRequest request, HttpServletResponse response) {

		return "register";
	}
	
	@PostMapping("/register")
	@ResponseBody
	public AjaxResult ajaxRegister(String account, String password, String membername) {
		int rows = loginService.register(account, password, membername);
		return toAjax(rows);
	}
	
	@GetMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
	}
}
