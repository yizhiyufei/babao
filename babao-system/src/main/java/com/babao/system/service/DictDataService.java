package com.babao.system.service;

import java.util.List;

import com.babao.system.domain.DictData;

public interface DictDataService {
	List<DictData> getType(String dictType);
}
