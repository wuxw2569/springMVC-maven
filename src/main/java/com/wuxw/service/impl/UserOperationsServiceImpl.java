package com.wuxw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.wuxw.domain.User;
import com.wuxw.service.UserOperationsService;

/**
 * @author Edwin Chen
 *
 */
@Service
public class UserOperationsServiceImpl implements UserOperationsService {
	@Autowired
	private RedisTemplate redisTemplate;

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		/*
		 * boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
		 * public Boolean doInRedis(RedisConnection redisConnection) throws
		 * DataAccessException { RedisSerializer<String> redisSerializer =
		 * redisTemplate .getStringSerializer(); byte[] key =
		 * redisSerializer.serialize(user.getId()); byte[] value =
		 * redisSerializer.serialize(user.getName()); return
		 * redisConnection.setNX(key, value); } }); return result;
		 */
		ValueOperations<String, User> valueops = redisTemplate
				.opsForValue();
		valueops.set(user.getId(), user);
	}


	@Override
	public User getUser(String key) {
		ValueOperations<String, User> valueops = redisTemplate
				.opsForValue();
		User user = valueops.get(key);
		return user;
	}

}
