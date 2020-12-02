package com.example.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.Product;
import com.example.Student;
import com.example.StudentInfo;

public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:applicationContext.xml";
		String path2 = "classpath:applicationContext2.xml";
		
		ApplicationContext ctx = new GenericXmlApplicationContext(path, path2);
		Student jimin = ctx.getBean("student1", Student.class);
		System.out.println(jimin);
		
		StudentInfo info = ctx.getBean("studentInfo1", StudentInfo.class);
		// 참고로 studentInfo1은 applicationContext.xml에서 student1을 ref했다.
		if(jimin== info.getStudent()) System.out.println("같아요");
		else System.out.println("달라요");
		
		Product p = ctx.getBean("product", Product.class);
		// product는 applcationContext2.xml에 있다.
		System.out.println(p);
		
	}
}
