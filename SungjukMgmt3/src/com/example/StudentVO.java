package com.example;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentVO {

	private String hakbun, name;
	private int kor, eng, mat;
	private int tot;
	private double avg;
	private char grade;

}