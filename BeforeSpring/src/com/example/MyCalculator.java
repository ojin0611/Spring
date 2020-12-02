package com.example;

public class MyCalculator {

	private Calculator calculator;			//MyCalculator : calculator에게 종속되어있음.
	private int firstNum;
	private int secondNum;
	
	public MyCalculator(Calculator calculator, int firstNum, int secondNum) {		//생성자를 통해서도 MVC 유사모델 구현 가능.
		this.calculator = calculator;
		this.firstNum = firstNum;
		this.secondNum = secondNum;
	}
	
//	public void setFirstNum(int firstNum) {
//	this.firstNum = firstNum;
//	}
//	
//	public void setSecondNum(int secondNum) {
//	this.secondNum = secondNum;
//	}
//	
//	public void setCalculator(Calculator calculator){
//	this.calculator = calculator;
//	}
//	
	public void add(){
	this.calculator.addAction(firstNum, secondNum);
	}
	
	public void sub(){
	this.calculator.subAction(firstNum, secondNum);
	}
	
	public void multi(){
		this.calculator.multiAction(firstNum, secondNum);
	}
	
	public void div(){
	this.calculator.divAction(firstNum, secondNum);
	}
	
}
