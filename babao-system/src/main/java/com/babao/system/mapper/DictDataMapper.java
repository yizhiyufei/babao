package com.babao.system.mapper;

import com.babao.system.domain.pojo.DictData;

import java.util.List;

public interface DictDataMapper {
	List<DictData> selectDictByType(String dictType);
}
