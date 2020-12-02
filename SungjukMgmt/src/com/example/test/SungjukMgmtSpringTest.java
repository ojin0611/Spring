package com.example.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.Calculator;
import com.example.StudentVO;

//Annotation으로 Test하는 방법.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class SungjukMgmtSpringTest {

	@Autowired		//Test에서 init()하지 않아도 됨.
	private ApplicationContext context;
	
	@Test
	public void method() {
		Calculator myCalculator = 
				this.context.getBean("myCalculator", Calculator.class);
		//세팅.
		myCalculator.calcTot();
		myCalculator.calcAvg();
		myCalculator.calcGrade();
		//bean.xml에서 younghee가져오기.
		StudentVO younghee = this.context.getBean("younghee", StudentVO.class);
		//영희가 이미 계산 끝났으므로 바로 테스트.
		//assertNotNull(younghee);
		assertEquals("A", String.valueOf(younghee.getGrade()) );		//asertEquals의 괄호 안에 char못넣음. 따라서 String으로 변환해서 넣기.
		
	}
}
