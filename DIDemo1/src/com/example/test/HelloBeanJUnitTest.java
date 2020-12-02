package com.example.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Hello;
import com.example.config.AppCtx;

public class HelloBeanJUnitTest {

	private ApplicationContext ctx;
	
	@Before  //Test이전에 해야할 일을 진행.
	public void init() {
		this.ctx = new AnnotationConfigApplicationContext(AppCtx.class);
	}
	
	@Test
	public void test() {
		Hello hello = (Hello)this.ctx.getBean("hello");
		assertEquals("Hello Spring", hello.sayHello());		//첫번째 : 예상값, 두번째 :실제값.
	}

}
