package com.example.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Hello;
import com.example.Printer;
import com.example.config.AppCtx;

public class HelloBeanTest {

	public static void main(String[] args) {
		
		//xml파일로 의존주입하는 이전 방법.
//		ApplicationContext ctx = 
//				new GenericXmlApplicationContext("classpaht:beans.xml");
		
		//Java Annotation을 이용한 방법이므로 annotation (AppCtx.java)에서 가져옴.
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppCtx.class); 

		Hello hello = (Hello)ctx.getBean("hello");
		System.out.println(hello.sayHello());
		//print호출해서 버퍼에 누적.
		hello.print();
		
		Printer sPrinter = ctx.getBean("sPrinter", Printer.class);
		System.out.println(sPrinter);		//sPrinter.toString();
	
		Hello hello1 = ctx.getBean("hello", Hello.class);
		if(hello == hello1) {
			System.out.println("같은 객체~");
		}else {
			System.out.println("다른 객체 ㅜ.ㅠ");
		}
		
	}
	
}
