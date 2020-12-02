package com.babao.freamewoke.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

	/**
	 * 保存字符串
	 * @param key
	 * @param value
	 */
	public void saveStr(String key, String value){
		valueOperations.set(key,value);
	}

	/**
	 * 保存无序集合
	 */
	public void saveSet(String key, String value) {
		setOperations.add(key,value);
	}

	public String getValue(String key){
		return (String) valueOperations.get(key);
	}
}
