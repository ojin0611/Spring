package com.example;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		Student student = context.getBean("student", Student.class);
		System.out.println(student);
		System.out.println("----------------------------------");
		Student student1 = context.getBean("student", Student.class);
		student1.setName("설운도");
		student1.setAge(55);
		student1.setGender("male");
		
		System.out.println(student1);
		System.out.println("----------------------------------");
		// 이게 무슨 뜻이냐면, 객체를 2개 만들었는데 두 객체는 같은 곳을 바라보고있다는 뜻이야!
		if (student.equals(student1))
			System.out.println("Equals"); // Print Equals
		else
			System.out.println("Different");
		context.close();
	}
}
