package com.babao.system.domain;

import java.util.Date;

import com.babao.common.enums.OnlineEnum;

/**
 * 用于封装登录状态实体
 * @author yizhiyufei
 *
 */
public class Online extends BaseEntity {
private static final long serialVersionUID = 1L;
    
    /** 用户会话id */
    private String sessionId;

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
    private OnlineEnum status = OnlineEnum.OFF_LINE;

    /** session创建时间 */
    private Date startTimestamp;

    /** session最后访问时间 */
    private Date lastAccessTime;

    /** 超时时间，单位为分钟 */
    private Long expireTime;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

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

	public OnlineEnum getStatus() {
		return status;
	}

	public void setStatus(OnlineEnum status) {
		this.status = status;
	}

	public Date getStartTimestamp() {
		return startTimestamp;
	}

	public void setStartTimestamp(Date startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public Date getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public Long getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
