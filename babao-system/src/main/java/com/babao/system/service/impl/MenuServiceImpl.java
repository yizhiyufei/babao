package com.babao.system.service.impl;

import com.babao.system.domain.Menu;
import com.babao.system.mapper.MenuMapper;
import com.babao.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	MenuMapper menuMapper;
	@Override
	public List<Menu> selectMenuAll() {

		return menuMapper.selectMenuAll();
	}

}
