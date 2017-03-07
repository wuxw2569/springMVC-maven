package com.wuxw.service;

import com.wuxw.domain.User;

/**
 * @author Edwin Chen
 *
 */
public interface UserOperationsService {
	void add(User user);
	User getUser(String key);
	
}
