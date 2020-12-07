package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Component("hello")
public class Hello {
	@Value("Spring")
	private String name;
	
	@Autowired
	// 만약 여기서 autowired만 썼다면, Printer 타입으로 연결하는데 그러면 stringPrinter랑 consolePrinter 2개가 있다.
	// 그래서 이름으로 연결해주는 Qualifier까지 넣어줘야한다.
	@Qualifier("stringPrinter")
	private Printer printer;

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}
}
