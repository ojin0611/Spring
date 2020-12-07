package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass2 {
	public static void main(String[] args) {
		// 1. Container 생성
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		// annotation은 load가 없다. 설정까지 한번에!
		
		/*
		// 2. Container 설정
		context.load("classpath:applicationContext.xml");
		context.refresh();
		*/
		
		// 3. Container 실행 - Container가 관리하는 bean 생성
		Student student3 = context.getBean("student3", Student.class);
		System.out.println(student3);
		
		// 4. Container 종료
		context.close();
		
		
		// 2번째 container의 life cycle 시작
		context = new AnnotationConfigApplicationContext(ApplicationConfig2.class);
		
		Student student4 = context.getBean("student4", Student.class);
		System.out.println(student4);
		
		// 4. Container 종료
		context.close();
		
	}
}