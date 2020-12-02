package com.babao.system.domain.dto;

import com.babao.system.domain.enums.LevelEnum;
import lombok.Data;

/**
 * 试卷接收对象
 */
@Data
public class TestPaperDto {
    //单选题数量
    private Integer singleNum;
    //多选题数量
    private Integer multipleNum;
    //简单题数量
    private Integer shortNum;
    //试题难度
    private LevelEnum quLevel;
    //答题时间
    private Integer answerTime;
    //备注
    private String remark;
}
