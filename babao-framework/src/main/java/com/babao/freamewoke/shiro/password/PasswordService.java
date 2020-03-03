package com.babao.freamewoke.shiro.password;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

/**
 * 密码加密验证业务
 * @author yizhiyufei
 *
 */
@Service
public class PasswordService {
	/**
	 * md5加密
	 * @param username 账号
	 * @param password	密码明文
	 * @param salt 私盐
	 * @param hashIterations 散列次数
	 * @return
	 */
	public String encryptMd5(String username,String password,String salt,int hashIterations) {
		SimpleHash hash = new SimpleHash("md5",password,username + salt,hashIterations);
		return hash.toHex();
	}
	public String encryptPassword(String username,String password,String salt) {
		SimpleHash hash = new SimpleHash("md5",password,username + salt,2);
		return hash.toHex();
	}
	public String getRandomSalt() {
		return new SecureRandomNumberGenerator().nextBytes().toHex();
	}
	public SimpleHash toHex(String hashAlgorithmName,Object credentials, Object salt, int hashIterations) {
		return new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
	}
}
