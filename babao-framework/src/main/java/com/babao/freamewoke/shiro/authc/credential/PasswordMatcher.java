package com.babao.freamewoke.shiro.authc.credential;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.babao.common.enums.StatusEnum;
import com.babao.freamewoke.redis.RedisService;
import com.babao.freamewoke.shiro.password.PasswordService;
import com.babao.system.domain.Member;
import com.babao.system.service.MemberService;

import lombok.extern.slf4j.Slf4j;

/**
 * 密码验证
 * 
 * @author yizhiyufei
 *
 */
@Slf4j
public class PasswordMatcher extends HashedCredentialsMatcher {
	private Cache<String, AtomicInteger> retryPassword;
	@Autowired
	private CacheManager cacheManager;
	@Autowired
	PasswordService passwordService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private RedisService redisService;

	@PostConstruct
	public void init() {
		retryPassword = cacheManager.getCache("retryPassword");
	}

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String account = upToken.getUsername();
		String inputPassword = new String(upToken.getPassword());
		
		String accountCredentials = (String) info.getCredentials();
		ByteSource byteSalt = ((SaltedAuthenticationInfo) info).getCredentialsSalt();
		//将ByteSource解码
		String salt = Base64.decodeToString(byteSalt.toString());
		String tokenHashedCredentials = passwordService.encryptPassword(account, inputPassword, salt);
		
		boolean matches =  tokenHashedCredentials.equals( accountCredentials);
		AtomicInteger retryCount = retryPassword.get(account);
		boolean retryNull = retryCount == null;
		Member member = (Member) info.getPrincipals().getPrimaryPrincipal();
		
		/**
		 * 如果验证成功，缓存中值又不存在，代表缓存超时，改回用户状态为OK
		 * 如果验证失败，缓存中值也不存在，代表第一次输入错误，存入缓存
		 * 如果缓存值大于5，修改用户状态为锁定，并抛异常
		 */
		if(matches) {
			if (retryNull) {			
				member.setMemberStatus(StatusEnum.OK);
	        	memberService.changeStatus(member);
			}else {
				throw new LockedAccountException("Account lockout");
			}
		}else {			
			if (retryNull) {
				retryPassword.put(account, new AtomicInteger(1));
				throw new IncorrectCredentialsException("Wrong password");
			}
			if (retryCount.incrementAndGet() > 5 && member.getStatusEnum().getCode() != 1) {
				member.setMemberStatus(StatusEnum.LOCKED);
	        	memberService.changeStatus(member);	        	
			}if(retryCount.get() <= 5 ) {
				log.error("重试密码次数:"+retryCount.toString());
				throw new ExcessiveAttemptsException("More password retries");
			}
			matches = false;		
		}
		redisService.countLogin();
		return matches;		
	}
}
