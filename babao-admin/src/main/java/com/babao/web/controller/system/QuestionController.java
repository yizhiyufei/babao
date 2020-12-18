package com.babao.web.controller.system;

import com.babao.common.croe.controller.BaseController;
import com.babao.common.croe.domain.AjaxResult;
import com.babao.common.croe.page.TableDataInfo;
import com.babao.common.utils.html.RichTextUtil;
import com.babao.common.utils.uuid.IdUtils;
import com.babao.freamewoke.redis.RedisService;
import com.babao.system.domain.dto.QuestionDto;
import com.babao.system.domain.enums.QuestionEnum;
import com.babao.system.domain.pojo.DictData;
import com.babao.system.domain.pojo.Question;
import com.babao.system.service.impl.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private RedisService redisService;

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
        for (Question q : list){
            q.setTrueRate("88%");
            q.setAnswers(90);
        }
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

    /**
     * 保存试题
     * @param dto
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult saveAdd(QuestionDto dto){
        log.info(dto.toString());
        Map<String, Map<String,List>>qumap = RichTextUtil.parseQuestion(dto.getContent());
        List<Question> quList = new ArrayList<>();
        for (String str : qumap.keySet()){
            System.out.println("题目是:"+ str);
            Map<String,List>mapList = qumap.get(str);
            List<String> options = mapList.get("options");
            List<String> correct = mapList.get("correct");
            for (String o :options){
                System.out.println("选项："+o);
            }
            for (String o :correct){
                System.out.println("正确答案："+o);
            }

        }
//        // 保存题号
//        String number = null;
//        for(String str : texts){
//            //判断是否题目名
//            if (str.contains("Q:")){
//                Question qu = new Question(dto.getQuLevel(),dto.getQuType(),dto.getScore(),1);
//                BeanUtils.copyProperties(dto,qu);
//                qu.setQuName(str);
//                //生成题号
//                number = IdUtils.fastSimpleUUID();
//                qu.setQuNumber(number);
//                quList.add(qu);
//                continue;
//            }
//            //如果是简答题redis存入字符串
//            if (dto.getQuType() == QuestionEnum.SHORT){
//                redisService.saveOptions(number,str,1);
//                continue;
//            }
//            // TODO 正确答案没有指定保存
//            //存在多个选择答案的题型rdis存入集合
//            redisService.saveOptions(number,str,2);
//        }
//        //批量保存
//        questionService.batchAdd(quList);
        return AjaxResult.success();
    }
}
