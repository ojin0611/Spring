package com.example.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.Hello;
import com.example.Printer;

public class HelloBeanJUnitTest {

	private ApplicationContext ctx;
	
	//@Before : Test이전에 해야할 일.
	@Before
	public void init() {
		//1step : Container 생성.
		String path = "classpath:beans.xml";
		this.ctx = new GenericXmlApplicationContext();
	}

	//@Ignore : 이 부분은 실행하지 마!
	@Ignore @Test
	public void test1() {
		Hello hello = this.ctx.getBean("hello", Hello.class);
		assertEquals("Hello Spring!", hello.sayHello());		//값 비교.
	}
	
	@Ignore @Test
	public void test2() {
		Hello hello = this.ctx.getBean("hello", Hello.class);
		hello.print();
		
		//3step : SpringPrinter 가져오기.
		Printer sprinter = (Printer)this.ctx.getBean("sPrinter");		//자식은 부모형으로 형변환 가능.
		assertEquals("Hello Spring!", sprinter.toString());		//값 비교.
	}
	
	//주소 비교.
	@Test
	public void test3() {
		Hello hello = (Hello)this.ctx.getBean("hello");
		Hello hello1 = this.ctx.getBean("hello", Hello.class);
		assertSame(hello, hello1);		//주소 비교.
	}
	
}
