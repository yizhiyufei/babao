package com.babao.system.service.impl;

import com.babao.system.domain.DictData;
import com.babao.system.mapper.DictDataMapper;
import com.babao.system.service.DictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dictDataService")
public class DictDataServiceImpl implements DictDataService {

	@Autowired
	DictDataMapper dictDataMapper;
	@Override
	public List<DictData> getType(String dictType) {
		return dictDataMapper.selectDictByType(dictType);
	}

}
