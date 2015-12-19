package com.earner.info.core.dao;

import java.util.List;

import com.earner.info.common.LogInPojo;
import com.earner.info.core.model.User;


public interface UsersDao {
	public List<User> getAllUsers();

	public void saveOrUpdate(User dwp);

	public boolean isAuthenticated(LogInPojo loginPojo);

	public User findUserByName(String userName);

	
}
