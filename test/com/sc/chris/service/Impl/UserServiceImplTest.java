package com.sc.chris.service.Impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sc.chris.entity.User;
import com.sc.chris.service.UserService;

public class UserServiceImplTest {

	@Test
	public void testGetAll() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
		UserService userService = (UserService)ctx.getBean("userService");
		List<User> list = userService.getAll();
		assertEquals(11, list.size());
	}

}
