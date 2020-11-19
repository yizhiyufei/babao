package com.babao.system.domain;

import com.babao.system.domain.enums.QuestionEnum;
import lombok.Data;

import java.util.List;

/**
 * @ClassName : TestPaper
 * @Author : Administrator
 * @Date: 2020/11/19 23:40
 * @Description : 试卷
 */
@Data
public class TestPaper {
    /** 题型 */
    private QuestionEnum qutype;
    /** 单选题列表 */
    private List<Integer> select;
    private Integer selectNum;
}
