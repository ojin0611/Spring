package com.example.test;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Student;
import com.example.config.ApplicationConfig;

public class MainClass {
	public static void main(String[] args) {
		/*
		String configFile = "classpath:applicationContext.xml";
		AbstractApplicationContext context = new GenericXmlApplicationContext(configFile);
		Student student1 = context.getBean("student1", Student.class);
		System.out.println(student1);
		Student student3 = context.getBean("student3", Student.class);
		System.out.println(student3);
		*/
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Student chulsu = (Student)ctx.getBean("student1");
		System.out.println(chulsu);
		System.out.println("-----------------------");
		
		Student younghee = ctx.getBean("student1", Student.class);
		younghee.setName("이영희");
		younghee.setAge(15);
		younghee.setHobbys(Arrays.asList("땅파기", "돌던지기", "숨쉬기"));
		younghee.setWeight(94.2);
		younghee.setHeight(195.4);
		System.out.println(younghee);
		System.out.println("-----------------------");
		
		System.out.println(chulsu == younghee);
	}
}
