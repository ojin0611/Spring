package com.example.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.Hello;
import com.example.Printer;

@RunWith(SpringJUnit4ClassRunner.class)		
//TestContext FramWork이므로 5행 import해줘야함.
@ContextConfiguration(locations="classpath:beans.xml")
public class HelloBeanJunitSpringTest {

	//자동으로 바인딩.	// @Before할 필요 없음.
	@Autowired
	private ApplicationContext ctx;		//runtime때 beans.xml과 바인딩.
	
	@Test
	public void test1() {
		Hello hello = this.ctx.getBean("hello", Hello.class);
		assertEquals("Hello Spring!", hello.sayHello());		//값 비교.
	}
	
	@Test
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
