package com.babao.system.mapper;

import com.babao.freamewoke.mybatisplus.mapper.BatchMapper;
import com.babao.system.domain.enums.QuestionEnum;
import com.babao.system.domain.pojo.Question;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * @ClassName : QuestionMapper
 * @Author : Administrator
 * @Date: 2020/11/4 1:01
 * @Description : 题目映射
 */
public interface QuestionMapper extends BatchMapper<Question> {
    Set<Question> randByQeAndLimit(@Param("qe") QuestionEnum qe, @Param("limit") int limit);
}
