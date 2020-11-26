package com.babao.web.controller.system;

import com.babao.common.croe.controller.BaseController;
import com.babao.common.croe.page.TableDataInfo;
import com.babao.system.domain.pojo.DictData;
import com.babao.system.domain.pojo.Question;
import com.babao.system.service.impl.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
public class QuestionController extends BaseController {
    private final String prefix = "system/question";
    @Autowired
    private QuestionService questionService;

    /**
     * 试题页面
     * @param map
     * @return
     */
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

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list() {
        startPage();
        List<Question> list = questionService.getAll();
        return getDataTable(list);
    }

    /**
     * 编辑试题
     * @return
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }
}
