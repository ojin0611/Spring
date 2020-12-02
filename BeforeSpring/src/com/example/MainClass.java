package com.example;

public class MainClass {

	//MainClass(뷰) : MyCalculator(중간자)를 통해서 Calculator (데이터 처리) 호출.
	
	public static void main(String[] args) {
		
		MyCalculator myCalculator = new MyCalculator(new Calculator(), 10, 2);		//MyCalculator를 통해서 Calculator 호출.
//		myCalculator.setCalculator(new Calculator());
//		myCalculator.setFirstNum(10);
//		myCalculator.setSecondNum(2);
		myCalculator.add();
		myCalculator.sub();
		myCalculator.multi();
		myCalculator.div();
	}

}
