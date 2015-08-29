package com.sc.chris.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sc.chris.dao.UserDao;
import com.sc.chris.entity.User;
import com.sc.chris.service.UserService;

@Component("userService")
public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean exists(User user) {
		return userDao.existsCheckName(user);
	}

	@Override
	public int addUser(User user) {
		boolean exist = exists(user);
		if (!exist) {
			userDao.add(user);
			return 0;
		} else {
			return 1;
		}
		
	}

	@Override
	public List<User> getAll() {
		return (List<User>) userDao.getAllEntity();
	}

	@Override
	public User loadUser(String id) {
		List<User> list = userDao.loadUserModel(id);
		if (list != null && list.size()==1) {
			return list.get(0);
		} else {
			return null;
		}		
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return userDao.loadUser(id);
	}

}
