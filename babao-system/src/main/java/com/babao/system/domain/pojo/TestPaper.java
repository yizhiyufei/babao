package com.babao.system.domain.pojo;

import com.babao.system.domain.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class TestPaper extends BaseEntity {
    private String title;
    private String paperNum;
    private Double score;
    /** 单选题列表 */
    private List<Select> selects;
    /** 多选题列表 */
    private List<Multiple> multiplees;
    /** 简答题列表 */
    private List<ShortAnswer> shorts;
}
