package com.babao.freamewoke.shiro.session.mgt;

import org.apache.shiro.session.mgt.SimpleSession;
import com.babao.common.enums.OnlineEnum;

/**
 * 用于保存当前登录成员的在线状态
 * @author yizhiyufei
 *
 */
public class OnlineSession extends SimpleSession {
	 /** 成员ID */
    private Integer memberId;
    
    /** 角色名称 */
    private String roleName;

    /** 登录姓名 */
    private String memberName; 

    /** 登录IP地址 */
    private String systemHost;

    /** 浏览器类型 */
    private String browser;

    /** 操作系统 */
    private String os;

    /** 在线状态 */
    private OnlineEnum online;

    /** 属性是否改变 优化session数据同步 */
    private transient boolean attributeChanged = false;

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getSystemHost() {
		return systemHost;
	}

	public void setSystemHost(String systemHost) {
		this.systemHost = systemHost;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public OnlineEnum getOnline() {
		return online;
	}

	public void setOnline(OnlineEnum online) {
		this.online = online;
	}

	public boolean isAttributeChanged() {
		return attributeChanged;
	}

	public void setAttributeChanged(boolean attributeChanged) {
		this.attributeChanged = attributeChanged;
	}
    
    
}
