package com.babao.system.domain;

/**
 * 专业信息表
 * @author yizhiyufei
 */
public class Specialty {
	//专业号
	private Integer specialtyId;
	//专业名
	private String specialtyName;
	public Integer getSpecialtyId() {
		return specialtyId;
	}
	public void setSpecialtyId(Integer specialtyId) {
		this.specialtyId = specialtyId;
	}
	public Specialty(Integer specialtyId, String specialtyName) {
		super();
		this.specialtyId = specialtyId;
		this.specialtyName = specialtyName;
	}
	public String getSpecialtyName() {
		return specialtyName;
	}
	public void setSpecialtyName(String specialtyName) {
		this.specialtyName = specialtyName;
	}
	public Specialty() {
		super();
	}
	@Override
	public String toString() {
		return "Specialty [specialtyId=" + specialtyId + ", specialtyName=" + specialtyName + "]";
	}
	
	
}
