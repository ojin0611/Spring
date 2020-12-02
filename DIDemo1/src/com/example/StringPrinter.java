package com.example;

public class StringPrinter implements Printer {

	private StringBuffer buffer;		//memver변수 = property
	
	public StringPrinter() {		//생성자.
		this.buffer = new StringBuffer();
	}
	
	//Printer interface를 구현했으므로, Printer의 메소드 재정의.
	@Override
	public void print(String message) {
		this.buffer.append(message);		//buffer에 message를 담기.
	}

	public String toString(){
		return this.buffer.toString();
	}
	
}