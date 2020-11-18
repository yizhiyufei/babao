//package com.babao.web.controller.system;
//
//import java.util.List;
//
//import org.apache.shiro.SecurityUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import com.babao.common.croe.controller.BaseController;
//import com.babao.common.croe.domain.AjaxResult;
//import com.babao.common.croe.page.TableDataInfo;
//import com.babao.freamewoke.shiro.password.PasswordService;
//import com.babao.system.domain.Member;
//import com.babao.system.service.MemberService;
///**
// * 成员控制类
// * @author yizhiyufei
// *
// */
//@Controller
//@RequestMapping("/system/member")
//public class MemberController extends BaseController {
//	private String prefix = "system/member";
//	@Autowired
//	private MemberService memberService;
//	@Autowired
//	PasswordService passwordService;
//
//
//    @GetMapping()
//    public String user()
//    {
//        return prefix+"/member";
//    }
//
//    /**
//     * 成员列表
//     * @param member 搜索条件
//     * @return
//     */
//    @PostMapping("/list")
//    @ResponseBody
//    public TableDataInfo list(Member member)
//    {
//        startPage();
//        List<Member> list = memberService.selectMemberList(member);
//        return getDataTable(list);
//    }
//
//	/**
//     * 新增用户
//     */
//    @GetMapping("/add")
//    public String add(ModelMap mmap)
//    {
////        mmap.put("roles", roleService.selectRoleAll());
////        mmap.put("posts", postService.selectPostAll());
//        return prefix + "/add";
//    }
//
//    /**
//     * 删除
//     * @param memberId 成员Id
//     * @return
//     */
//    @PostMapping("/remove")
//    @ResponseBody
//    public AjaxResult remove(String memberId){
//    	return toAjax(memberService.deleteMemberByIds(memberId));
//    }
//
//    /**
//     * 修改密码
//     * @param userId
//     * @param mmap
//     * @return
//     */
//    @GetMapping("/editPwd/{memberAccount}")
//    public String resetPwd(@PathVariable("memberAccount") String memberAccount,ModelMap map){
//    	Member member = memberService.selectMemberByAccount(memberAccount);
//    	map.put("member", member);
//        return prefix + "/editPwd";
//    }
//
//    /**
//     * 重置密码
//     * @param userId
//     * @param mmap
//     * @return
//     */
//    @GetMapping("/resetPwd/{memberId}")
//    public String resetPwd(@PathVariable("memberId") Integer memberId,ModelMap map){
//    	Member member = memberService.selectMemberById(memberId);
//    	map.put("member", member);
//        return prefix + "/resetPwd";
//    }
//
//    /**
//     * 提交密码
//     * @param aim 修改提交或者重置提交
//     * @param member
//     * @return
//     */
//    @PostMapping("/PwdSave/{aim}")
//    @ResponseBody
//    public AjaxResult PwdSave(@PathVariable("aim")String aim , Member member){
//    	int rows = 0;
//    	String encryptPassword;
//    	System.out.println(member.toString());
//    	switch(aim) {
//    		case "reset":
//    			String salt = passwordService.getRandomSalt();
//    			encryptPassword = passwordService.encryptPassword(member.getMemberAccount(), member.getPassword(), salt);
//    			member.setSalt(salt);
//    			member.setPassword(encryptPassword);
//    			rows = memberService.UpdatePassword(member);
//    			break;
//    		case "edit":
//    			Member principal = (Member) SecurityUtils.getSubject().getPrincipal();
//    			encryptPassword = passwordService.encryptPassword(principal.getMemberAccount(), member.getPassword(), principal.getSalt());
//    			member.setPassword(encryptPassword);
//    			rows = memberService.UpdatePassword(member);
//    	}
//    	return toAjax(rows);
//    }
//
//    /**
//     * 检验密码
//     * @param password
//     * @return
//     */
//    @GetMapping("/checkPassword")
//    @ResponseBody
//    public boolean checkPassword(String password){
//    	Member principal = (Member) SecurityUtils.getSubject().getPrincipal();
//    	String encryptPassword = passwordService.encryptPassword(principal.getMemberAccount(), password, principal.getSalt());
//        if(principal.getPassword().equals(encryptPassword)) {
//        	return true;
//        }
//        return false;
//    }
//
//    /**
//     * 修改状态
//     * @param user
//     * @return
//     */
//    @PostMapping("/changeStatus")
//    @ResponseBody
//    public AjaxResult changeStatus(Member member)
//    {
//        return toAjax(memberService.changeStatus(member));
//    }
//
//}
