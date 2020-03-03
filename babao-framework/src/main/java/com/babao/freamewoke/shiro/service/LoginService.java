package com.babao.freamewoke.shiro.service;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babao.freamewoke.shiro.password.PasswordService;
import com.babao.system.domain.Member;
import com.babao.system.service.MemberService;
import com.github.pagehelper.util.StringUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 登录注册校验方法
 * 
 * @author yizhiyufei
 *
 */
@Slf4j
@Service
public class LoginService {

	@Autowired
	private MemberService memberService;
	@Autowired
	PasswordService passwordService;
	@Autowired
	private CacheManager cacheManager;

	private Cache<String, Integer> wrongPassword;

	@PostConstruct
	public void init() {
		wrongPassword = cacheManager.getCache("retryPassword");
	}

	/**
	 * 登录
	 * 
	 * @param account
	 * @param password
	 * @return
	 */
	public Member login(String account, String password) {
		if (StringUtil.isEmpty(account) || StringUtil.isEmpty(password)) {
			throw new UnknownAccountException("The username password is empty");
		}
		Member member = memberService.selectMemberByAccount(account);
		String encryptPassword = passwordService.encryptPassword(account, password, member.getSalt());
		if (null == member) {
			log.error("输入错误账号");
			throw new UnknownAccountException("Account does not exist");
		}
		if (!encryptPassword.equals(member.getPassword())) {
			log.error("输入错误密码");
			Integer retryCount = wrongPassword.get(account);
			if (retryCount == null) {
				retryCount = new Integer(1);
				wrongPassword.put(account, retryCount);
			} else {
				wrongPassword.put(account, ++retryCount);
			}
			log.error("错误密码次数:" + retryCount);
			throw new IncorrectCredentialsException("Wrong username/password");
		}
		if (account.equals(member.getMemberAccount()) && encryptPassword.equals(member.getPassword())) {
			log.info("登录成功");
			return member;
		} else {
			throw new IncorrectCredentialsException("Wrong username/password");
		}
	}

	/**
	 * 注册
	 * 
	 * @param account
	 *            账号
	 * @param password
	 *            密码明文
	 * @param membername
	 *            姓名
	 */
	public int register(String account, String password, String membername) {
		String salt = passwordService.getRandomSalt();
		log.info("a salt" + salt);
		log.info("enter password" + password);
		String encryptPassword = passwordService.encryptPassword(account, password, salt);
		log.info("encrypted password" + encryptPassword);
		Member member = new Member(1, account, membername, encryptPassword, salt);
		return memberService.addMember(member);
	}
}
