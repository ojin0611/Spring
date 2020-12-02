package com.example;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
//@AllArgsConstructor		//생성자 생성.
//@RequiredArgsConstructor		//필수 변수(NonNull인 변수)의 생성자 생성.
//@NoArgsConstructor		//기본 생성자.
//@ToString					//toString().
public class StudentVO {

	private @NonNull String hakbun, name;		// @NonNull : hakbun, name은 필수!
	private @NonNull int kor, eng, mat, tot;
	private double avg;
	private char grade;

}