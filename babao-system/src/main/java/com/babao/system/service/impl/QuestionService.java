package com.babao.system.service.impl;

import com.babao.system.domain.pojo.DictData;
import com.babao.system.domain.pojo.Question;
import com.babao.system.mapper.QuestionMapper;
import com.babao.system.service.BaseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @ClassName : QuestionService
 * @Author : Administrator
 * @Date: 2020/11/2 23:36
 * @Description : 题目业务实现
 */
@Service
@Slf4j
public class QuestionService implements BaseService<Question> {
    @Autowired
    private QuestionMapper questionMapper;
//    @Autowired
//    private

    /**
     * 添加题目及答案
     * @param question
     */
    @Override
    public boolean add(Question question) {
        //时间戳+题型编号+科目编号
        String number = String.valueOf(new Date().getTime()) + "-" + question.getQuType().getCode() + "-" + question.getCourseId();
        question.setQuNumber(number);
        log.info(number);
        if(questionMapper.insert(question)>0){
            //插入答案
            return true;
        }
        return false;
    }

    /**
     * 查询所有题目
     * @return
     */
    @Override
    public List<Question> getAll() {
        QueryWrapper<Question> ew = new QueryWrapper<>();
        ew.eq("deleted",0);
        return questionMapper.selectList(ew);
    }

    /**
     * 删除题目
     * @param id 根据主键条件
     * @return
     */
    @Override
    public boolean del(Integer id) {
        return questionMapper.deleteById(id)>0?true:false;
    }


    public List<DictData> selectCourses() {
        DictData d1 = new DictData();
        d1.setDictLabel("编程");
        DictData d2 = new DictData();
        d2.setDictLabel("英语");
        return Arrays.asList(d1,d2);
    }
}
