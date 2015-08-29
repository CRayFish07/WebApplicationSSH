package com.sc.chris.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.sc.chris.entity.User;
import com.sc.chris.service.UserService;

@Component("showAllUser")
@Scope("prototype")
public class ShowAllUserAction extends ActionSupport {

	@Resource
	private UserService userService;
	private List<User> users;
	
	@Override
	public String execute() throws Exception {
		users = userService.getAll();
		return "showUsers";
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
