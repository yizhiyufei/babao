package com.babao.system.domain.dto;

import com.babao.system.domain.enums.LevelEnum;
import com.babao.system.domain.enums.QuestionEnum;
import lombok.Data;

/**
 * @ClassName : QuestionDto
 * @Author : Administrator
 * @Date: 2020/11/27 21:49
 * @Description : 保存试题
 */
@Data
public class QuestionDto {

    private LevelEnum quLevel;//难度
    private QuestionEnum quType;//题型
    private Integer fraction;//分数
    private String content;//富文本内容
}
