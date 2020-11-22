package com.babao.web.controller.system;

import com.babao.system.domain.pojo.DictData;
import com.babao.system.service.impl.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName : QuestionController
 * @Author : Administrator
 * @Date: 2020/11/21 22:22
 * @Description : 题库控制器
 */
@Controller
@Slf4j
@RequestMapping("/question")
public class QuestionController {
    private final String prefix = "system/question";
    @Autowired
    private QuestionService questionService;

    @GetMapping("/index")
    public String index(ModelMap map) {

        return prefix + "/index";
    }

    @GetMapping("/type")
    @ResponseBody
    public List<DictData> type() {
        List<DictData> courses = questionService.selectCourses();
        return courses;
    }
}
