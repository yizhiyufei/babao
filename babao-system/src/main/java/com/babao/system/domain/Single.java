package com.babao.system.domain;
/**
 * 单选题表
 * @author yizhiyufei
 *
 */
public class Single {
	//单选题号
	private Integer singleId;
	//题型号
	private Integer questionId;
	//问题
	private String singleText;
	//选项A
	private String singleOpA;
	//选项B
	private String singleOpB;
	//选项C
	private String singleOpC;
	//选项D
	private String singleOpD;
	//答案
	private String singleAnsw;
	public Integer getSingleId() {
		return singleId;
	}
	public void setSingleId(Integer singleId) {
		this.singleId = singleId;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public String getSingleText() {
		return singleText;
	}
	public void setSingleText(String singleText) {
		this.singleText = singleText;
	}
	public String getSingleOpA() {
		return singleOpA;
	}
	public void setSingleOpA(String singleOpA) {
		this.singleOpA = singleOpA;
	}
	public String getSingleOpB() {
		return singleOpB;
	}
	public void setSingleOpB(String singleOpB) {
		this.singleOpB = singleOpB;
	}
	public String getSingleOpC() {
		return singleOpC;
	}
	public void setSingleOpC(String singleOpC) {
		this.singleOpC = singleOpC;
	}
	public String getSingleOpD() {
		return singleOpD;
	}
	public void setSingleOpD(String singleOpD) {
		this.singleOpD = singleOpD;
	}
	public String getSingleAnsw() {
		return singleAnsw;
	}
	public void setSingleAnsw(String singleAnsw) {
		this.singleAnsw = singleAnsw;
	}
	public Single(Integer singleId, Integer questionId, String singleText, String singleOpA, String singleOpB,
			String singleOpC, String singleOpD, String singleAnsw) {
		super();
		this.singleId = singleId;
		this.questionId = questionId;
		this.singleText = singleText;
		this.singleOpA = singleOpA;
		this.singleOpB = singleOpB;
		this.singleOpC = singleOpC;
		this.singleOpD = singleOpD;
		this.singleAnsw = singleAnsw;
	}
	public Single() {
		super();
	}
	@Override
	public String toString() {
		return "Single [singleId=" + singleId + ", questionId=" + questionId + ", singleText=" + singleText
				+ ", singleOpA=" + singleOpA + ", singleOpB=" + singleOpB + ", singleOpC=" + singleOpC + ", singleOpD="
				+ singleOpD + ", singleAnsw=" + singleAnsw + "]";
	}
	
	
}
