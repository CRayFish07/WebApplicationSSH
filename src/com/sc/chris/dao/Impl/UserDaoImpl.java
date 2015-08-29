package com.sc.chris.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sc.chris.dao.GenericDao;
import com.sc.chris.dao.UserDao;
import com.sc.chris.entity.User;

@Component("userDao")
public class UserDaoImpl extends GenericDao implements UserDao{	
	
	@Override
	public boolean existsCheckName(User user) {
		String queryString = "select username from User u where u.username = '" + user.getUsername() + "'";
		int size = this.getHibernateTemplate().find(queryString).size();
		return size>0;
	};

	@Override
	public void add(User user) {
		this.getHibernateTemplate().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllEntity() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().loadAll(User.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> loadUserModel(String id) {		
		String queryString = "from User u where u.id = ?";
		List<User> user = this.getHibernateTemplate().find(queryString, Integer.parseInt(id));
		return user;
	}

	@Override
	public User loadUser(int id) {
		// TODO Auto-generated method stub
		return (User) this.getHibernateTemplate().load(User.class, id);
	}

}
