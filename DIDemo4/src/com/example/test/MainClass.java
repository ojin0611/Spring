package com.example.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Student;
import com.example.StudentInfo;
import com.example.config.ApplicationConfig;

public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		StudentInfo info = context.getBean("studentInfo", StudentInfo.class);
		info.printInfo();
		context.close();
	}
}