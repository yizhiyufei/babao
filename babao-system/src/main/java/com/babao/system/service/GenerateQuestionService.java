package com.babao.system.service;

import com.babao.system.domain.pojo.TestPaper;
import com.babao.system.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 出题模板业务
 */
public abstract class GenerateQuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    private TestPaper testPaper;

    public void build(TestPaper testPaper){
        this.testPaper = testPaper;
        singleSelect();
        MultipleSelect();
        fill();
        shortAnswer();
    }

    /** 单项选择 */
    protected  void singleSelect(){
//        questionMapper.
    }
    /** 多项选择 */
    protected abstract void MultipleSelect();
    /** 填空 */
    protected void  fill(){

    }
    /** 简答 */
    protected abstract void shortAnswer();
}
