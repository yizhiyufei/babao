package com.babao.system.domain.pojo;

import com.babao.freamewoke.shiro.accout.StatusEnum;

/**
 * 角色信息表
 * @author yizhiyufei
 *
 */
public class Role {
	/** 角色ID */
    private Integer roleId;

    /** 角色名称 */
    private String roleName;

    /** 角色权限 */
    private String roleKey;
    
    /** 父级角色id*/
    private Integer parentRoleId;

    /** 角色排序 */
    private String roleSort;
    
    /** 角色状态 */
    private StatusEnum roleStatus;
    
    
	public Integer getParentRoleId() {
		return parentRoleId;
	}

	public void setParentRoleId(Integer parentRoleId) {
		this.parentRoleId = parentRoleId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}

	public String getRoleSort() {
		return roleSort;
	}

	public void setRoleSort(String roleSort) {
		this.roleSort = roleSort;
	}

	public StatusEnum getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(StatusEnum roleStatus) {
		this.roleStatus = roleStatus;
	}
    
    
}
