package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.StudentInfo;

@Configuration
//내가 곧 XML 하나다.
@ComponentScan(basePackages = { "com.example" })
public class ApplicationConfig {
	@Bean
	public StudentInfo studentInfo() {
		return new StudentInfo();
	}
}