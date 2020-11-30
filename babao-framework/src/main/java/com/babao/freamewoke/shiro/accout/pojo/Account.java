package com.babao.freamewoke.shiro.accout.pojo;

import com.babao.freamewoke.shiro.accout.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

/**
 * 成员信息表 member
 * @author yizhiyufei
 *
 */
@Setter
@Getter
public class Account{
	private Integer memberId;
	private String memberAccount;
	private String memberName;
	private String password;
	private String salt;
	private StatusEnum statusEnum;
	private String avatar;
	private Integer roleId;
	/** 创建时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	public StatusEnum getStatusEnum() {
		return statusEnum;
	}
	public void setMemberStatus(StatusEnum statusEnum) {
		this.statusEnum = statusEnum;
	}
	public Account(Integer roleId, String memberAccount, String memberName, String password, String salt) {
		super();
		this.roleId = roleId;
		this.memberAccount = memberAccount;
		this.memberName = memberName;
		this.password = password;
		this.salt = salt;
	}
	public Account() {
		super();
	}

	public String toString() {
		return "Account [memberId=" + memberId + ", memberAccount=" + memberAccount + ", memberName=" + memberName
				+ ", password=" + password + ", salt=" + salt + ", statusEnum=" + statusEnum + ", avatar=" + avatar
				+ ", roleId=" + roleId + "]";
	}
	
}
