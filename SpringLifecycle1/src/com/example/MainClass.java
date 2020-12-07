package com.example;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		// 1
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		
		// 2
		context.load("classpath:applicationContext.xml"); 
		context.refresh(); // bean 생성
		
		// 3
		Student student = context.getBean("student", Student.class);
		System.out.println(student);
		
		// 4
		context.close(); // bean 소멸
	}
}