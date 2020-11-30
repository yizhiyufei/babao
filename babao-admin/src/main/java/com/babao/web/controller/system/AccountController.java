package com.babao.web.controller.system;

import com.babao.common.croe.controller.BaseController;
import com.babao.common.croe.domain.AjaxResult;
import com.babao.common.croe.page.TableDataInfo;
import com.babao.freamewoke.shiro.password.PasswordService;
import com.babao.freamewoke.shiro.accout.pojo.Account;
import com.babao.system.service.impl.AccountService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 成员控制类
 * @author yizhiyufei账号
 *
 */
@Controller
@RequestMapping("/system/member")
public class AccountController extends BaseController {
	private String prefix = "system/member";
	@Autowired
	private AccountService memberService;
	@Autowired
	PasswordService passwordService;


    @GetMapping()
    public String user()
    {
        return prefix+"/member";
    }

    /**
     * 成员列表
     * @param member 搜索条件
     * @return
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Account member)
    {
        startPage();
        List<Account> list = memberService.selectAccountList(member);
        return getDataTable(list);
    }

	/**
     * 新增用户
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
//        mmap.put("roles", roleService.selectRoleAll());
//        mmap.put("posts", postService.selectPostAll());
        return prefix + "/add";
    }

    /**
     * 删除
     * @param memberId 成员Id
     * @return
     */
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String memberId){
    	return toAjax(memberService.deleteAccountByIds(memberId));
    }

    /**
     * 修改密码
     * @param memberAccount
     * @param map
     * @return
     */
    @GetMapping("/editPwd/{memberAccount}")
    public String resetPwd(@PathVariable("memberAccount") String memberAccount,ModelMap map){
    	Account member = memberService.selectAccountByAccount(memberAccount);
    	map.put("member", member);
        return prefix + "/editPwd";
    }

    /**
     * 重置密码
     * @param memberId
     * @param map
     * @return
     */
    @GetMapping("/resetPwd/{memberId}")
    public String resetPwd(@PathVariable("memberId") Integer memberId,ModelMap map){
    	Account member = memberService.selectAccountById(memberId);
    	map.put("member", member);
        return prefix + "/resetPwd";
    }

    /**
     * 提交密码
     * @param aim 修改提交或者重置提交
     * @param member
     * @return
     */
    @PostMapping("/PwdSave/{aim}")
    @ResponseBody
    public AjaxResult PwdSave(@PathVariable("aim")String aim , Account member){
    	int rows = 0;
    	String encryptPassword;
    	System.out.println(member.toString());
    	switch(aim) {
    		case "reset":
    			String salt = passwordService.getRandomSalt();
    			encryptPassword = passwordService.encryptPassword(member.getMemberAccount(), member.getPassword(), salt);
    			member.setSalt(salt);
    			member.setPassword(encryptPassword);
    			rows = memberService.UpdatePassword(member);
    			break;
    		case "edit":
    			Account principal = (Account) SecurityUtils.getSubject().getPrincipal();
    			encryptPassword = passwordService.encryptPassword(principal.getMemberAccount(), member.getPassword(), principal.getSalt());
    			member.setPassword(encryptPassword);
    			rows = memberService.UpdatePassword(member);
    	}
    	return toAjax(rows);
    }

    /**
     * 检验密码
     * @param password
     * @return
     */
    @GetMapping("/checkPassword")
    @ResponseBody
    public boolean checkPassword(String password){
    	Account principal = (Account) SecurityUtils.getSubject().getPrincipal();
    	String encryptPassword = passwordService.encryptPassword(principal.getMemberAccount(), password, principal.getSalt());
        if(principal.getPassword().equals(encryptPassword)) {
        	return true;
        }
        return false;
    }

    /**
     * 修改状态
     * @param member
     * @return
     */
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(Account member)
    {
        return toAjax(memberService.changeStatus(member));
    }

}
