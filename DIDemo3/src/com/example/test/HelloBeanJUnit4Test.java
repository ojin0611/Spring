package com.example.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.Hello;
import com.example.Printer;

public class HelloBeanJUnit4Test {
	private ApplicationContext ctx;
	
	@Before
	public void init() {
		this.ctx = new GenericXmlApplicationContext("config/annos.xml");
	}
	
	@Ignore @Test
	public void test() {
		assertNotNull(this.ctx);
	}
	
	@Ignore @Test
	public void test1() {
		Hello hello = (Hello)this.ctx.getBean("hello");
		//assertEquals("Hello 한지민", hello.sayHello());
		hello.print();
		Printer printer = (Printer)this.ctx.getBean("stringPrinter");
		assertEquals("Hello 한지민", printer.toString());
	}
	
	@Test
	public void test2() {
		Hello hello = (Hello)this.ctx.getBean("hello");
		Hello hello2 = this.ctx.getBean("hello", Hello.class);
		assertSame(hello, hello2);
	}

}
