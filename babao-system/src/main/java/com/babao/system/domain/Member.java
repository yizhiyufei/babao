package com.babao.system.domain;

import com.babao.common.croe.domain.BaseEntity;
import com.babao.common.enums.StatusEnum;

/**
 * 成员信息表 member
 * @author yizhiyufei
 *
 */
public class Member extends BaseEntity{
	private Integer memberId;
	private String memberAccount;
	private String memberName;
	private String password;
	private String salt;
	private StatusEnum statusEnum;
	private String avatar;
	private Integer roleId;
	
	public Integer getRoleId() {
		return roleId;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public void setStatusEnum(StatusEnum statusEnum) {
		this.statusEnum = statusEnum;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemberAccount() {
		return memberAccount;
	}
	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}	
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public StatusEnum getStatusEnum() {
		return statusEnum;
	}
	public void setMemberStatus(StatusEnum statusEnum) {
		this.statusEnum = statusEnum;
	}
	public Member(Integer roleId, String memberAccount, String memberName, String password, String salt) {
		super();
		this.roleId = roleId;
		this.memberAccount = memberAccount;
		this.memberName = memberName;
		this.password = password;
		this.salt = salt;
	}
	public Member() {
		super();
	}
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberAccount=" + memberAccount + ", memberName=" + memberName
				+ ", password=" + password + ", salt=" + salt + ", statusEnum=" + statusEnum + ", avatar=" + avatar
				+ ", roleId=" + roleId + "]";
	}
	
}
