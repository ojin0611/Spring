package com.example.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.ApplicationConfig;
import com.example.service.UserService;
import com.example.service.UserServiceImpl;
import com.example.vo.UserVO;

// Presentation Layer
public class MainClass {
	public static void main(String[] args) {
		// ApplicationContext ctx = new GenericXmlApplicationContext("classpath:beans.xml");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		// Service Layer 호출!!
		UserService userService = (UserServiceImpl)ctx.getBean("userService");
		UserVO userVO = userService.getUser("jimin");
		System.out.println(userVO);
		
	}
}
