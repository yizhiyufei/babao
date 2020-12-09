package com.babao.system.domain.pojo;

import com.babao.system.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Setter
@Getter
public class TestPaper extends BaseEntity {
    private String title;
    private String paperNum;
    private Double score;
    private Integer answerTime;
    //备注
    private String remark;
    /** 单选题列表 */
    private Set<Select> selects;
    /** 多选题列表 */
    private Set<Multiple> multiplees;
    /** 简答题列表 */
    private Set<ShortAnswer> shorts;

    public TestPaper() {
        super();
        selects = new LinkedHashSet<>();
        multiplees = new LinkedHashSet<>();
        shorts = new LinkedHashSet<>();
    }

    public void addSelect(Select s){
        selects.add(s);
    }
    public void addMultiple(Multiple m){
        multiplees.add(m);
    }
    public void addShortAnswer(ShortAnswer sa){
        shorts.add(sa);
    }
}
