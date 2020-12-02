package com.example.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.Hello;
import com.example.Printer;
import com.example.StringPrinter;
import com.example.config.AppCtx;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppCtx.class})		//class명시.  {} 배열로도 들어감.			
public class HelloBeanJUnitSpringTest {

	@Autowired
	private ApplicationContext ctx;
	
//	@Before  //Test이전에 해야할 일을 진행.
//	public void init() {
//		this.ctx = new AnnotationConfigApplicationContext(AppCtx.class);
//	}
	
	@Ignore @Test
	public void method1() {
		Hello hello = (Hello)this.ctx.getBean("hello");
		assertEquals("Hello Spring", hello.sayHello());
	}
	@Ignore @Test
	public void method2() {
		Hello hello = this.ctx.getBean("hello", Hello.class);
		hello.print();
		Printer printer = this.ctx.getBean("sPrinter", StringPrinter.class);		//뒤에 클래스 넣어줌 : StringPrinter로 강제 형변환.
		assertEquals("Hello Spring", printer.toString());		//값 비교.
	}
	@Test
	public void method3() {
		Printer printer = this.ctx.getBean("sPrinter", StringPrinter.class);		//뒤에 클래스 넣어줌 : StringPrinter로 강제 형변환.
		Printer printer1 = (StringPrinter)this.ctx.getBean("sPrinter");
		assertSame(printer, printer1);		//주소 비교.
	}
	
	
}