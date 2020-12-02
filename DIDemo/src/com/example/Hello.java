package com.example;

public class Hello {

	private String name;		//property : member 변수.
	private Printer printer;	//Printer의 자식도 멤버변수로 받을 수 있음.

	public Hello(String name, Printer printer) {
		this.name = name;
		this.printer = printer;
	}

//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setPrinter(Printer printer) {		//Printer의 자식도 파라미터로 받을 수 있음.
//		this.printer = printer;
//	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
