package com.babao.web.controller.system;

import com.babao.common.croe.controller.BaseController;
import com.babao.common.croe.domain.AjaxResult;
import com.babao.freamewoke.redis.RedisService;
import com.babao.system.domain.dto.TestPaperDto;
import com.babao.system.domain.pojo.*;
import com.babao.system.service.impl.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;
import java.util.stream.Collectors;

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
        TestPaper paper = new TestPaper();
        paper.setAnswerTime(dto.getAnswerTime());
        paper.setRemark(dto.getRemark());
        Set<Question> quSet = questionService.createTestPaper(dto);
        for (Question q: quSet){
            switch (q.getQuType()){
                case SHORT:
                    /**
                     * 通过题号从redis找答案
                     * 将问题，答案封装
                     */
                    String answer = redisService.getValue(q.getQuNumber());
                    ShortAnswer sa = new ShortAnswer(q.getQuName(),q.getScore(),answer);
                    paper.addShortAnswer(sa);
                    break;
                case SINGLE:
                    Set<Object> singleSet = redisService.getSet(q.getQuNumber());
                    Set<String> singleOp = singleSet.stream().map(o -> (String) o).collect(Collectors.toSet());
                    Select select = new Select(q.getQuName(),q.getScore(),2,singleOp);
                    paper.addSelect(select);
                    break;
                case MULTIPLE:
                    Set<Object> multipleSet = redisService.getSet(q.getQuNumber());
                    Set<String> multiplOp = multipleSet.stream().map(o -> (String) o).collect(Collectors.toSet());
                    Integer[] arr = {1,2};
                    Multiple multiple = new Multiple(q.getQuName(),q.getScore(),arr,multiplOp);
                    paper.addMultiple(multiple);
                    break;
            }
        }

        return AjaxResult.success(paper);
    }
}
