package com.babao.system.domain.pojo;

import com.babao.system.domain.BaseEntity;
import com.babao.system.domain.enums.QuestionEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 试题信息表
 * @author yizhiyufei
 *
 */
@Data
public class Question extends BaseEntity {
	//主键
	@TableId(type = IdType.AUTO)
	private Integer id;
	//题型名
	private String quName;
	//编号
	private String quNumber;
	//试题难度
	private Integer quLevel;
	//题型
	private QuestionEnum quType;
	//所属科目
	private Integer courseId;
	//答案
	@TableField(exist = false)
	private Answer answer;

	public Question() {
	}
}
