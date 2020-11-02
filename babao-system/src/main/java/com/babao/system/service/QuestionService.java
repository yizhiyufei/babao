package com.babao.system.service;

import com.babao.system.domain.Question;

/**
 * @ClassName : QuestionService
 * @Author : Administrator
 * @Date: 2020/11/2 23:31
 * @Description : 题目业务层
 */

public interface QuestionService {
    /**
     * 添加题目
     * @param question
     */
    public void add(Question question);
}
