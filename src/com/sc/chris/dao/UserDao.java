package com.sc.chris.dao;

import java.util.List;

import com.sc.chris.entity.User;

public interface UserDao {

	public boolean existsCheckName(User user);
	public void add(User user);
	public List<User> getAllEntity();
	public List<User> loadUserModel(String id);
	public User loadUser(int id);
}
