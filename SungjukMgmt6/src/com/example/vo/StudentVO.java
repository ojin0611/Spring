package com.example.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
public class StudentVO {
	@NonNull private String hakbun;
	@NonNull private String name;
	@NonNull private int kor;
	@NonNull private int eng;
	@NonNull private int mat;
	private int tot;
	private double avg;
	private char grade;

}
