package com.babao.web.controller.system;

import com.babao.common.config.Global;
import com.babao.system.domain.Menu;
import com.babao.system.domain.pojo.Account;
import com.babao.system.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class IndexController {
	@Autowired
	MenuService menuService;
	// 系统首页
    @GetMapping("/index")
    public String index(ModelMap map) {
    	Account account = (Account) SecurityUtils.getSubject().getPrincipal();
    	List<Menu> menus = menuService.selectMenuAll();
    	map.put("account", account);
    	map.put("menus", menus);
    	return "index";
    }

 // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap map)
    {
        map.put("version", Global.getVersion());
        return "main";
    }
}
