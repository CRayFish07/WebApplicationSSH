package com.sc.chris.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sc.chris.dto.UserDTO;
import com.sc.chris.entity.User;
import com.sc.chris.service.UserService;

//@Component("user")
//@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<Object> {
	
	private static final long serialVersionUID = 1L;
	
	private UserDTO userDTO = new UserDTO();
	private String id;
	private User user;
	private List<User> users;
	private UserService userService;
	
	@Override
	public String execute() throws Exception {
		System.out.println(userDTO.getUsername());
		String password = userDTO.getPassword();
		String password2 = userDTO.getPassword2();
		if (password == null || password2 == null || !password.equals(password2) ) {
			return "fail";
		}
		User user = new User(userDTO.getUsername(), password);
		int status = getUserService().addUser(user);
		return status == 0 ? "success" : "fail";
		
	}
	
	public String list(){
		users = getUserService().getAll();
		return "list";
	}
	
	public String checkUser(){
		user = getUserService().loadUser(id);
		return "checkuser";
	}
	
	public String getUserById(){
		user = userService.getUser(Integer.parseInt(id));
		return "getUserById";
		
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return userDTO;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
}
