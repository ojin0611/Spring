package com.example.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Student;
import com.example.StudentInfo;
import com.example.config.ApplicationConfig;

public class ApplicationTest {
	private ApplicationContext ctx;
	
	@Before
	public void init() {
		this.ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	}

	@Test
	public void test() {
		assertNotNull(this.ctx);
		Student jimin = this.ctx.getBean("student1", Student.class);
		System.out.println(jimin);
		
		StudentInfo info = this.ctx.getBean("studentInfo", StudentInfo.class);
		info.printInfo();
	}

}
