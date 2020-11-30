package com.babao.freamewoke.shiro.accout;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum StatusEnum {
	OK(0,"正常"),LOCKED(1,"锁定"),DISABLE(2,"禁用"),DELETED(3,"删除"),SHOW(4,"显示"),HIDDEN(5,"隐藏");
	@EnumValue
	private final int code;
    private final String info;
	private StatusEnum(int code,String info) {
		this.code = code;
		this.info = info;
	}
	public int getCode() {
		return code;
	}
	public String getInfo() {
		return info;
	}
	public String toString() {
		return name();
	}
}
