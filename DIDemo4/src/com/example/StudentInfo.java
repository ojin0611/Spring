package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor // 기본생성자
@Component
public class StudentInfo {
	// @Autowired는 xml에서 component scan을 해야 사용할 수 있다.
	// Annotation만 사용할 때 autowired 기능을 쓰고싶어서 아래 방법을 이용한다.
	@Setter(onMethod_ = @Autowired)
	// Setter에 3가지 속성을 부여할 수 있다. value, onMethod : setter method에 추가할 annotation, onParam
	private Student student;

	public void printInfo() {
		if (this.student != null) {
			System.out.println("Name : " + this.student.getName());
			System.out.println("Age : " + this.student.getAge());
			System.out.println("Hobbies");
			this.student.getHobbys().forEach(hobby -> System.out.println(hobby));
			System.out.println("Height : " + this.student.getHeight());
			System.out.println("Weight : " + this.student.getWeight());
		} else {
			System.out.println("Null");
		}
	}
}