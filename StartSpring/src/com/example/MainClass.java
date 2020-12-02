package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;	//3행의 자식.

public class MainClass {
	
	public static void main(String[] args) {
		
		//applicationContext.xml에서 세팅한 값을 받아오기만 하면 됌.
		
		ApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");		//applicationContext.xml을 찾아.
		
		//방법 1 : ID로만 가져오기.
		MyCalculator mc = (MyCalculator)ctx.getBean("myCalculator");		//applicationContext.xml의 myCalculator이름의 빈을 가져와서 형변환.
		//방법 2 : ID와 클래스 지정해서 가져오기.
		//MyCalculator mc1 = ctx.getBean("myCalculator", MyCalculator.class);
		
//		if(mc == mc1) {
//			System.out.println("같은 객체");
//		}else {
//			System.out.print("다른 객체");
//		}
		
		mc.add();
		mc.sub();
		mc.multi();
		mc.div();
		
	}
	
	
}