package com.example.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Student;
import com.example.config.ApplicationConfig;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println(student1);
		Student student3 = ctx.getBean("student3", Student.class);
		System.out.println(student3);
	}
}
