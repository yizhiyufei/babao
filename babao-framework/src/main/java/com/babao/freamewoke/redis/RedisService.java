package com.babao.freamewoke.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Service
@Slf4j
public class RedisService {
	@Autowired
	private ValueOperations valueOperations;
	@Autowired
	SetOperations<String, Object> setOperations;
	
	/**
	 * 统计每日登录人数
	 */
	public void countLogin() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy--MM--dd");
		LocalDateTime now = LocalDateTime.now();
		String key = "loginDate:" + now.format(formatter);
		valueOperations.increment(key);
	}


	public String getValue(String key){
		return (String) valueOperations.get(key);
	}

	public Set<Object> getSet(String key){
		Set<Object> set = setOperations.members(key);
		return set;
	}

	/**
	 * 保存题目选项
	 * @param number
	 * @param value
	 * @param i
	 */
	public void saveOptions(String number, String value, int i) {
		String key = "quOptions:" + number;
		if (i == 1) valueOperations.set(key,value);
		if (i == 2) setOperations.add(key,value);
	}
}
