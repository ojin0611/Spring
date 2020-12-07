package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.Calculator;
import com.example.StudentVO;

public class SungjukMgmtTest {
	private ApplicationContext ctx;
	
	@BeforeEach
	public void init() {
		this.ctx = new GenericXmlApplicationContext("classpath:beans.xml");
	}
	
	@Test
	public void test() {
		assertNotNull(this.ctx);
	}
	
	@Test
	public void test1() {
		StudentVO chulsu = (StudentVO)ctx.getBean("student");
		//assertEquals("한지민", chulsu.getName());
		Calculator cal = ctx.getBean("calculator", Calculator.class);
		cal.calcTot();   cal.calcAvg();   cal.calcGrade();
		assertEquals(100+84+76, chulsu.getTot());
	}

}
