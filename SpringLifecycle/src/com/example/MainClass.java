package com.example;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		// 1. Container 생성
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		
		// 2. Container 설정
		context.load("classpath:applicationContext.xml");
		context.refresh();
		
		// 3. Container 실행 - Container가 관리하는 bean 생성
		Student student1 = context.getBean("student1", Student.class);
		System.out.println(student1);
		
		// 여기에 context.load() 로 다른 xml을 불러온후 refresh할 수 없다. 반드시 다음 life-cycle에서 진행해야한다.
		
		
		// 4. Container 종료
		context.close();
		
		
		// 2번째 container의 life cycle 시작
		
		
	}
}