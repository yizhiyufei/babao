package com.babao.system.domain.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @ClassName : LevelEnum
 * @Author : Administrator
 * @Date: 2020/11/27 21:50
 * @Description : 等级枚举
 */
@Getter
public enum LevelEnum {
    FIRST_LEVEL(1,"初级"),
    MIDDLE_LEVEL(2,"中级"),
    HIGH_LEVEL (3,"高级");
    @EnumValue
    private final int code;
    private final String info;

    LevelEnum(int code, String info) {
        this.code = code;
        this.info = info;
    }
}
