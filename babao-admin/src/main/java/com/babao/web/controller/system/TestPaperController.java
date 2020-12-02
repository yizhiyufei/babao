package com.babao.web.controller.system;

import com.babao.common.croe.controller.BaseController;
import com.babao.common.croe.domain.AjaxResult;
import com.babao.freamewoke.redis.RedisService;
import com.babao.system.domain.dto.TestPaperDto;
import com.babao.system.domain.pojo.Question;
import com.babao.system.domain.pojo.TestPaper;
import com.babao.system.service.impl.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.Set;

@Controller
@Slf4j
@RequestMapping("/paper")
public class TestPaperController extends BaseController {

    private final String prefix = "system/paper";

//    @Autowired
//    private TestPaperService testPaperService;

    @Autowired
    private QuestionService questionService;
    @Autowired
    private RedisService redisService;
    /**
     * 试卷管理页面
     * @param map
     * @return
     */
    @GetMapping("/index")
    public String index(ModelMap map) {
        return prefix + "/index";
    }

    @GetMapping("/add")
    public String add(ModelMap map) {
        return prefix + "/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult saveAdd(TestPaperDto dto) {
//        log.info(dto.toString());
        //TODO 封装试卷
        TestPaper paper = new TestPaper();
        Set<Question> quSet = questionService.createTestPaper(dto);
        for (Question q: quSet){
            switch (q.getQuType()){
                case SHORT:
                    String quShort = redisService.getValue(q.getQuNumber());
            }
        }
//        log.info(numberSet.toString());
        return AjaxResult.success(quSet);
    }
}
