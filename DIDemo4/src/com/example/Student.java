package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

// RequiredArgs는 NonNull인 애들만 들어온다. 그래서 설령 int에는 NonNull이 의미가 없더라도 이 annotation이 필요하다.

@Setter
@Getter
@Component
// Component 옆 괄호에 아무것도안쓰면 student가 된다. 즉, ("student")는 쓰나마다 default다.
public class Student {
	// 이렇게 값 다 넣어주면 Student 생성자로 값 넣어줄 필요가 없다. StudentInfo에서도 그냥바로불러쓰면된다.
	@Value("한지민")
	private String name;
	@Value("25")
	private int age;
	@Value("등산, 게임, 독서")
	private List<String> hobbys;
	@Value("162.5")
	private double height;
	@Value("49.2")
	private double weight;
}