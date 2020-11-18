//package com.babao.freamewoke.shiro.service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.babao.freamewoke.shiro.password.PasswordService;
//import com.babao.system.domain.Member;
//import com.babao.system.service.MemberService;
//
//import lombok.extern.slf4j.Slf4j;
//
///**
// * 登录注册校验方法
// *
// * @author yizhiyufei
// *
// */
//@Slf4j
//@Service
//public class LoginService {
//
//	@Autowired
//	private MemberService memberService;
//	@Autowired
//	PasswordService passwordService;
//
//	/**
//	 * 注册
//	 *
//	 * @param account
//	 *            账号
//	 * @param password
//	 *            密码明文
//	 * @param membername
//	 *            姓名
//	 */
//	public int register(String account, String password, String membername) {
//		String salt = passwordService.getRandomSalt();
//		log.info("a salt" + salt);
//		log.info("enter password" + password);
//		String encryptPassword = passwordService.encryptPassword(account, password, salt);
//		Member member = new Member(1, account, membername, encryptPassword, salt);
//		return memberService.addMember(member);
//	}
//}
