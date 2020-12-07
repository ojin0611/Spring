package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass3 {
	public static void main(String[] args) {
		// 1,2. Container 생성 및 설정
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig3.class);
		
		// 3. bean 생성
		Product notebook = ctx.getBean("product", Product.class);
		System.out.println(notebook);
		
		// 4. 종료
		ctx.close();
	}
}