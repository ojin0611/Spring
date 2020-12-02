package com.example.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Calculator;
import com.example.StudentVO;
import com.example.config.AppConfig;

public class SungjukMgmtTest {

	//xml로 환경설정했으므로 xml불러오기
	private ApplicationContext ctx;
	private Calculator myCalculator;
	
	@Before
	public void init() {
		this.ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		myCalculator = this.ctx.getBean("myCalculator", Calculator.class);		//beans.xml에서 id가 myCalculator인 bean을 호출. 
		myCalculator.calcTot();
		myCalculator.calcAvg();
		myCalculator.calcGrade();
	}
	
	@Test
	public void test() {
		StudentVO younghee = this.ctx.getBean("younghee", StudentVO.class);		//beans.xml에서 id가 chulsu인 bean을 가져와서 StudentVO형으로 변환.
		assertEquals("박지민", younghee.getName());		//정영희 : 실제 값과 비교하는 값,  younghee.getName() : 실제 값.
	}
	
	@Test
	public void test1() {
		StudentVO chulsu = (StudentVO)this.ctx.getBean("chulsu");		//32행과 유사.
	}

}
