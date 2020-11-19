package com.babao.system.service.impl;

import com.babao.common.enums.StatusEnum;
import com.babao.common.utils.StringUtils;
import com.babao.system.domain.Role;
import com.babao.system.domain.Ztree;
import com.babao.system.mapper.RoleMapper;
import com.babao.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	@Override
	public List<Ztree> selectRoleTree() {
		List<Ztree> ztreeList = new ArrayList<Ztree>();
		List<Role> roles = roleMapper.selectRoleList();
		for(Role role : roles) {
			Ztree ztree = new Ztree();
			ztree.setId(role.getRoleId());
			ztree.setName(role.getRoleName());
			ztree.setpId(role.getParentRoleId());
			ztreeList.add(ztree);
		}
        return ztreeList;
	}

	/**
     * 对象转部门树
     *
     * @param roleList 部门列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<Role> roleList)
    {
        return initZtree(roleList, null);
    }

    /**
     * 对象转部门树
     *
     * @param roleList 部门列表
     * @param roleDeptList 角色已存在菜单列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<Role> roleList, List<String> roleDeptList)
    {

        List<Ztree> ztrees = new ArrayList<Ztree>();
        boolean isCheck = StringUtils.isNotNull(roleDeptList);
        for (Role role : roleList)
        {
            if (StatusEnum.OK.equals(role.getRoleStatus()))
            {
                Ztree ztree = new Ztree();
                ztree.setId(role.getRoleId());
//                ztree.setpId(dept.getParentId());
                ztree.setName(role.getRoleName());
                ztree.setTitle(role.getRoleName());
//                if (isCheck)
//                {
//                    ztree.setChecked(roleDeptList.contains(dept.getDeptId() + dept.getDeptName()));
//                }
//                ztrees.add(ztree);
            }
        }
        return ztrees;
    }

}
