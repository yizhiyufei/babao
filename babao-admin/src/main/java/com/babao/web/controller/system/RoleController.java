//package com.babao.web.controller.system;
//
//import java.util.List;
//
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import com.babao.common.croe.controller.BaseController;
//import com.babao.system.domain.Role;
//import com.babao.system.domain.Ztree;
//import com.babao.system.service.RoleService;
//
///**
// * 角色信息控制器
// * @author yizhiyufei
// *
// */
//@Controller
//@RequestMapping("/system/role")
//public class RoleController extends BaseController
//{
//    private String prefix = "system/role";
//
//    @Autowired
//    private RoleService roleService;
//
//    @GetMapping()
//    public String dept()
//    {
//        return prefix + "/role";
//    }
//    /**
//     * 选择菜单树
//     */
//    @GetMapping("/treeData")
//    @ResponseBody
//    public List<Ztree> treeData()
//    {
//        List<Ztree> roleList = roleService.selectRoleTree();
//        return roleList;
//    }
//
////    @GetMapping("/list")
////    @ResponseBody
////    public List<Role> list()
////    {
////    	List<Role> roleList = roleService.selectRoleTree();
////        return roleList;
////    }
//}