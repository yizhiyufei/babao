package com.babao.system.domain.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @ClassName : QuestionEnum
 * @Author : Administrator
 * @Date: 2020/11/8 11:32
 * @Description : 题型枚举
 */
@Getter
public enum QuestionEnum {
    SINGLE(1,"单选"),
    MULTIPLE(2,"多选"),
    SHORT(3,"简答");
    @EnumValue
    private final int code;
    private final String info;

    QuestionEnum(int code, String info) {
        this.code = code;
        this.info = info;
    }
}
