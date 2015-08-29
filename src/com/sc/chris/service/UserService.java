package com.sc.chris.service;

import java.util.List;

import com.sc.chris.entity.User;

public interface UserService {
	
	public boolean exists(User user);
	public int addUser(User user);
	public List<User> getAll();
	public User loadUser(String id);
	public User getUser(int id);
	

}
