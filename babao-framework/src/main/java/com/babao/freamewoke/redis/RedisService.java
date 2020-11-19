package com.babao.freamewoke.redis;

import com.babao.system.domain.pojo.Answer;
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
	 * 保存答案
	 * 正确答案保存在String
	 * 选择项保存在Set
	 * @param key
	 * @param answer
	 */
	public void insertAnswer(String key, Answer answer){
		for (String str : answer.getCorrect()){
			valueOperations.append(key,str+",");
		}
		for (String str : answer.getSelect()){
			setOperations.add(key,str);
		}
	}
}
