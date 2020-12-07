package com.example;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
// InitializingBean, DisposableBean 은 초기화, 소멸을 위해 annotation 대신 인터페이스를 사용하는것
public class Student /* implements InitializingBean, DisposableBean */ {
	private String name;
	private int age;
	private String gender;
	private String city;

	/*
	 * @Override // from DisposableBean public void destroy() throws Exception {
	 * System.out.println("방금 Bean이 소멸됐습니다."); }
	 * 
	 * @Override // from InitilizingBean public void afterPropertiesSet() throws
	 * Exception { System.out.println("방금 Bean이 생성됐습니다."); }
	 */

	@PostConstruct // Bean이 생성단계에서 해야할 일 기술
	public void initTest() {
		System.out.println("방금 객체가 생성됐습니다.");
	}

	@PreDestroy // Bean이 소멸할 때 해야할 일 기술
	public void destroyTest() {
		System.out.println("방금 객체가 소멸됐습니다.");
	}
}