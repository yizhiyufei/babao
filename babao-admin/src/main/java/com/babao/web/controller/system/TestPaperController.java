package com.babao.web.controller.system;

import com.babao.common.croe.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/paper")
public class TestPaperController extends BaseController {

    private final String prefix = "system/paper";
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
}
