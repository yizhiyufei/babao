package com.babao.common.enums;
/**
 * 用户会话
 * @author yizhiyufei
 *
 */
public enum OnlineEnum {
	/** 用户状态 */
    ON_LINE("在线"), OFF_LINE("离线");

    private final String info;

    private OnlineEnum(String info)
    {
        this.info = info;
    }

    public String getInfo()
    {
        return info;
    }
}
