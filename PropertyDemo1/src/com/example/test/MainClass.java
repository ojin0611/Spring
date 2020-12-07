package com.example.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.AdminConnection;

public class MainClass {
	public static void main(String[] args) {
		//
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:beans.xml");
		
		//
		AdminConnection connection = ctx.getBean("adminConnection", AdminConnection.class);
		System.out.println("admin ID : " + connection.getAdminId());
		System.out.println("admin PWD : " + connection.getAdminPwd());
		System.out.println("sub admin ID : " + connection.getSubAdminId());
		System.out.println("sub admin PWD : " + connection.getSubAdminPwd());
		
		//
		ctx.close();
	}
}
