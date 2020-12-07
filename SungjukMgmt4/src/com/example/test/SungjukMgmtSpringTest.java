package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Calculator;
import com.example.StudentVO;
import com.example.config.AppConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
public class SungjukMgmtSpringTest {
	@Autowired
	private ApplicationContext context;
	
	@Test
	public void method() {
		Calculator myCalculator = 
				this.context.getBean("calculator", Calculator.class);
		myCalculator.calcTot();   myCalculator.calcAvg();
		myCalculator.calcGrade();
		StudentVO younghee = this.context.getBean("student", StudentVO.class);
		assertNotNull(younghee);
		assertEquals("B", "" + younghee.getGrade());
	}
	
}
