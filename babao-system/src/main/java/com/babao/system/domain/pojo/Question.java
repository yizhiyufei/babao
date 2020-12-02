package com.babao.system.domain.pojo;

import com.babao.system.domain.BaseEntity;
import com.babao.system.domain.enums.LevelEnum;
import com.babao.system.domain.enums.QuestionEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

/**
 * 试题信息表
 * @author yizhiyufei
 *
 */
@Setter
@Getter
public class Question extends BaseEntity {

	//题型名
	private String quName;
	//题号
	private String quNumber;
	//试题难度
	private LevelEnum quLevel;
	//题型
	private QuestionEnum quType;
	//分值
	private Double score;
	//所属科目
	private Integer courseId;

	//答题次数
	@TableField(exist = false)
	private Integer answers;
	//正确率
	@TableField(exist = false)
	private String trueRate;

	public Question() {
		super();
	}

	public Question(LevelEnum quLevel, QuestionEnum quType, Double score, Integer courseId) {
		this.quLevel = quLevel;
		this.quType = quType;
		this.score = score;
		this.courseId = courseId;
	}
}
