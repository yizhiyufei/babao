package com.babao.freamewoke.shiro.authc.credential;

import com.babao.freamewoke.shiro.accout.StatusEnum;
import com.babao.freamewoke.shiro.accout.pojo.Account;
import com.babao.freamewoke.redis.RedisService;
import com.babao.freamewoke.shiro.accout.mapper.AccountMapper;
import com.babao.freamewoke.shiro.password.PasswordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicInteger;

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
	private AccountMapper accountMapper;
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
		Account member = (Account) info.getPrincipals().getPrimaryPrincipal();
		
		/**
		 * 如果验证成功，缓存中值又不存在，代表缓存超时，改回用户状态为OK
		 * 如果验证失败，缓存中值也不存在，代表第一次输入错误，存入缓存
		 * 如果缓存值大于5，修改用户状态为锁定，并抛异常
		 */
		if(matches) {
			if (retryNull) {			
				member.setStatusEnum(StatusEnum.OK);
	        	accountMapper.updateAccount(member);
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
				accountMapper.updateAccount(member);
			}if(retryCount.get() <= 5 ) {
				log.error("重试密码次数:"+retryCount.toString());
				throw new ExcessiveAttemptsException("More password retries");
			}
			matches = false;		
		}
		//TODO 统计登录人数，redis未安装
//		redisService.countLogin();
		return matches;		
	}
}
