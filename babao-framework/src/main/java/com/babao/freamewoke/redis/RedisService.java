package com.babao.freamewoke.redis;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RedisService {
	@Autowired
	private ValueOperations valueOperations;
	
	/**
	 * 统计每日登录人数
	 */
	public void countLogin() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy--MM--dd");
		LocalDateTime now = LocalDateTime.now();
		String key = "loginDate:" + now.format(formatter);
		valueOperations.increment(key);
	}
}
