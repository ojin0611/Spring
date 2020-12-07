package com.example;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminConnection implements InitializingBean, DisposableBean {
	private String adminId;
	private String adminPwd;
	private String subAdminId;
	private String subAdminPwd;

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("방금 객체 초기화됐다~");
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("객체 소멸됐다~~");
	}
	
	@PostConstruct
	public void myInit() {
		System.out.println("객체 생성됨");
	}
	
	@PreDestroy
	public void myDestroy() {
		System.out.println("객체 소멸됨");
	}
}
