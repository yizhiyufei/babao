package com.babao.freamewoke.shiro.realm;

import com.babao.system.domain.pojo.Member;
import com.babao.system.service.MemberService;
import com.github.pagehelper.util.StringUtil;
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
public class MemberRealm extends AuthorizingRealm {
	@Autowired
	private MemberService memberService;
	
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
     
        if (StringUtil.isEmpty(account) || StringUtil.isEmpty(password)) {
			throw new UnknownAccountException("The username password is empty");
		} 

        Member member = memberService.selectMemberByAccount(account);
        
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
