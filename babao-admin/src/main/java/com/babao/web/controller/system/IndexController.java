package com.babao.web.controller.system;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.babao.common.config.Global;
import com.babao.system.domain.Member;
import com.babao.system.domain.Menu;
import com.babao.system.service.MenuService;

@Controller
public class IndexController {
	@Autowired
	MenuService menuService;
	// 系统首页
    @GetMapping("/index")
    public String index(ModelMap map)
    {
    	Member member = (Member) SecurityUtils.getSubject().getPrincipal();
    	List<Menu> menus = menuService.selectMenuAll();
    	map.put("member", member);
    	map.put("menus", menus);
    	return "index";
    }
    
 // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
    	mmap.put("version", Global.getVersion());
        return "main";
    }
}
