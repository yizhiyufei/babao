package com.babao.common.enums;
/**
 * 菜单类型枚举
 * C目录 M菜单 B按钮
 * @author yizhiyufei
 *
 */
public enum MenuType {
	CATALOGUE("C"),MENU("M"),BUTTON("B");
	private final String code;
	private MenuType(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	
}
