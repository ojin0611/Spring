package com.example.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.Hello;
import com.example.Printer;

public class HelloBeanTest {
	public static void main(String[] args) {
		ApplicationContext context = 
				new GenericXmlApplicationContext("config/annos.xml");//일반 폴더 config
		//new GenericXmlApplicationContext("classpath:beans.xml"), source folder config
		Hello hello = (Hello)context.getBean("hello");
		System.out.println(hello.sayHello());
		hello.print();
		
		Printer printer = (Printer)context.getBean("stringPrinter");
		System.out.println(printer.toString());
		
		Hello hello2 = context.getBean("hello", Hello.class);
		hello2.print();
		System.out.println(hello == hello2); //Singleton Pattern
	}
}
