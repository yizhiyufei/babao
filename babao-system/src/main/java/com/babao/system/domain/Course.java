package com.babao.system.domain;
/**
 * 科目信息表
 * @author yizhiyufei
 *
 */
public class Course {
	//科目编号
	private Integer courseId;
	//科目名
	private String courseName;
	//所属专业
	private String specialtyId;
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getSpecialtyId() {
		return specialtyId;
	}
	public void setSpecialtyId(String specialtyId) {
		this.specialtyId = specialtyId;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", specialtyId=" + specialtyId + "]";
	}
	public Course(Integer courseId, String courseName, String specialtyId) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.specialtyId = specialtyId;
	}
	public Course() {
		super();
	}
	
	
}
