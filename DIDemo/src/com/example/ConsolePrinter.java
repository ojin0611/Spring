package com.example;

public class ConsolePrinter implements Printer {

	
	//Printer interface를 구현했으므로, Printer의 메소드 재정의.
	@Override
	public void print(String message) {
		System.out.println(message);
	}

}
