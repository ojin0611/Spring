package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.Calculator;

@Configuration
@ComponentScan(basePackages = {"com.example"})
public class AppConfig {
	//@Bean
	//public Calculator myCalculator() {
	//	Calculator cal = new Calculator();
	//	return cal;
	//}
}
