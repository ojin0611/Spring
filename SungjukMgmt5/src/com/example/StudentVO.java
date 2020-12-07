package com.example;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component("student")
public class StudentVO {
	@Value("{hakbun}")
	private String hakbun;
	@Value("${name}")
	private String name;
	@Value("${kor}")
	private int kor;
	@Value("${eng}")
	private int eng;
	@Value("${mat}")
	private int mat;
	
	private int tot;
	private double avg;
	private char grade;
}
