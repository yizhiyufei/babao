package com.babao.system.domain.pojo;

import lombok.Data;

import java.util.Set;

/**
 * @ClassName : Answer
 * @Author : Administrator
 * @Date: 2020/11/8 11:22
 * @Description : 答案实体
 */
@Data
public class Answer{
    //选择答案
    private Set<String> select;
    //正确答案
    private String correct;

    public Answer() {
    }
}
