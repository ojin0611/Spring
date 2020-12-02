package com.example.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.Hello;
import com.example.Printer;

public class HelloBeanTest {
	
	public static void main(String[] args) {

		String path = "classpath:beans.xml";		//classpath 안에 beans.xml찾아.
		//1step. Container 생성하기.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		
		//2step. Hello Beans 가져오기.
		Hello hello = (Hello)ctx.getBean("hello");				//Hello객체의 주소 저장.
		//System.out.println(hello.sayHello());
		hello.print();			//Hello Spring을 StringBuffer에 담기.
		
		//3step : SpringPrinter 가져오기.
		Printer printer = (Printer)ctx.getBean("sPrinter");
		System.out.println(printer);		//printer.toString();
		
		Hello hello1 = ctx.getBean("hello", Hello.class);		//Hello객체의 주소 저장.
		if(hello1 == hello) {
			System.out.println("같은 객체!");		//싱글톤 패턴이므로 같은 객체!. (주소가 같으므로 오로지 hello는 하나)
		}else {
			System.out.println("다른 객체!");
		}
		
		//4step : Container 소멸.
		ctx.close();
	}
	
}
