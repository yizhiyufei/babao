package com.babao.system.service;

/**
 * 出题模板业务
 */
public abstract class GenerateQuestionService {
    
    public void build(){
        singleSelect();
        MultipleSelect();
        fill();
        shortAnswer();
    }

    protected abstract void singleSelect();
    protected abstract void MultipleSelect();
    protected abstract void fill();
    protected abstract void shortAnswer();
}
