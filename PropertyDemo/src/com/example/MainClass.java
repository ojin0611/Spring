package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:beans.xml");
		
		Hello2 hello = (Hello2) ctx.getBean("hello1");
		System.out.println(hello.sayHello());
		hello.print();
		
		Printer printer = ctx.getBean("stringPrinter", StringPrinter.class);
		System.out.println(printer.toString());
		hello.getHobbies().forEach(value -> System.out.println(value));
	}
}