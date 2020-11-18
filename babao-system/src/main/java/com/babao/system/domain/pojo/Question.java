package com.babao.system.domain.pojo;

import com.babao.system.domain.BaseEntity;
import com.babao.system.domain.enums.QuestionEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

/**
 * 试题信息表
 * @author yizhiyufei
 *
 */
@Data
@Builder
public class Question extends BaseEntity {
	//主键
	@TableId(type = IdType.AUTO)
	private Integer id;
	//编号
	private String quNumber;
	//题型
	private QuestionEnum quType;
	//题型名
	private String quName;
	//试题难度
	private Integer quLevel;
	//所属科目
	private Integer courseId;
	//答案
	@TableField(exist = false)
	private Answer answer;

	

	
	
	
}
