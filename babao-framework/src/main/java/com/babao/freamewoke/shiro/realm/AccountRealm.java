package com.babao.freamewoke.shiro.realm;

import com.babao.common.utils.StringUtils;
import com.babao.system.domain.pojo.Account;
import com.babao.system.service.impl.AccountService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 自定义realm，定义成员登录域
 * @author yizhiyufei
 *
 */
public class AccountRealm extends AuthorizingRealm {
	@Autowired
	private AccountService memberService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRole("admin");
		
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String account = upToken.getUsername();
        String password =  new String(upToken.getPassword());
     
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
			throw new UnknownAccountException("The username password is empty");
		} 

        Account member = memberService.selectAccountByAccount(account);
        
        if (null == member) {
			throw new UnknownAccountException("Account does not exist");
		}
        switch(member.getStatusEnum()) {
        	case OK:break;
        	case LOCKED:break;
        	case DISABLE:throw new DisabledAccountException("Account is disabled");
        	case DELETED:throw new UnknownAccountException("Account deleted");
        }
        
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(member, member.getPassword(), getName());
        info.setCredentialsSalt(ByteSource.Util.bytes(member.getSalt()));
        
        return info;
	}

}
