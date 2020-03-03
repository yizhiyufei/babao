package com.babao.system.domain;
/**
 * 多项选择题表
 * @author yizhiyufei
 *
 */
public class Multiple {
	//多选题号
	private Integer multipleId;
	//题型号
	private Integer questionId;
	//问题
	private String multipleText;
	//选项A
	private String multipleOpA;
	//选项B
	private String multipleOpB;
	//选项C
	private String multipleOpC;
	//选项D
	private String multipleOpD;
	//选项E
	private String multipleOpE;
	//选项F
	private String multipleOpF;
	//答案
	private String multipleAnsw;
	public Integer getMultipleId() {
		return multipleId;
	}
	public void setMultipleId(Integer multipleId) {
		this.multipleId = multipleId;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public String getMultipleText() {
		return multipleText;
	}
	public void setMultipleText(String multipleText) {
		this.multipleText = multipleText;
	}
	public String getMultipleOpA() {
		return multipleOpA;
	}
	public void setMultipleOpA(String multipleOpA) {
		this.multipleOpA = multipleOpA;
	}
	public String getMultipleOpB() {
		return multipleOpB;
	}
	public void setMultipleOpB(String multipleOpB) {
		this.multipleOpB = multipleOpB;
	}
	public String getMultipleOpC() {
		return multipleOpC;
	}
	public void setMultipleOpC(String multipleOpC) {
		this.multipleOpC = multipleOpC;
	}
	public String getMultipleOpD() {
		return multipleOpD;
	}
	public void setMultipleOpD(String multipleOpD) {
		this.multipleOpD = multipleOpD;
	}
	public String getMultipleOpE() {
		return multipleOpE;
	}
	public void setMultipleOpE(String multipleOpE) {
		this.multipleOpE = multipleOpE;
	}
	public String getMultipleOpF() {
		return multipleOpF;
	}
	public void setMultipleOpF(String multipleOpF) {
		this.multipleOpF = multipleOpF;
	}
	public String getMultipleAnsw() {
		return multipleAnsw;
	}
	public void setMultipleAnsw(String multipleAnsw) {
		this.multipleAnsw = multipleAnsw;
	}
	@Override
	public String toString() {
		return "Multiple [multipleId=" + multipleId + ", questionId=" + questionId + ", multipleText=" + multipleText
				+ ", multipleOpA=" + multipleOpA + ", multipleOpB=" + multipleOpB + ", multipleOpC=" + multipleOpC
				+ ", multipleOpD=" + multipleOpD + ", multipleOpE=" + multipleOpE + ", multipleOpF=" + multipleOpF
				+ ", multipleAnsw=" + multipleAnsw + "]";
	}
	public Multiple(Integer multipleId, Integer questionId, String multipleText, String multipleOpA, String multipleOpB,
			String multipleOpC, String multipleOpD, String multipleOpE, String multipleOpF, String multipleAnsw) {
		super();
		this.multipleId = multipleId;
		this.questionId = questionId;
		this.multipleText = multipleText;
		this.multipleOpA = multipleOpA;
		this.multipleOpB = multipleOpB;
		this.multipleOpC = multipleOpC;
		this.multipleOpD = multipleOpD;
		this.multipleOpE = multipleOpE;
		this.multipleOpF = multipleOpF;
		this.multipleAnsw = multipleAnsw;
	}
	public Multiple() {
		super();
	}
	
}
