package com.babao.system.domain;
/**
 * 试题信息表
 * @author yizhiyufei
 *
 */
public class Question {
	//题型号
	private Integer questionId;
	//题型名称
	private String questionName;
	//试题难度
	private String questionLevel;
	//所属科目
	private Integer courseId;
	
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionName=" + questionName + ", questionLevel="
				+ questionLevel + ", courseId=" + courseId + "]";
	}
	public Question(Integer questionId, String questionName, String questionLevel, Integer courseId) {
		super();
		this.questionId = questionId;
		this.questionName = questionName;
		this.questionLevel = questionLevel;
		this.courseId = courseId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public String getQuestionName() {
		return questionName;
	}
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	public String getQuestionLevel() {
		return questionLevel;
	}
	public void setQuestionLevel(String questionLevel) {
		this.questionLevel = questionLevel;
	}
	
	public Question() {
		super();
	}
	
	
	
}
