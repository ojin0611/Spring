package com.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example"})
public class ApplicationConfig3 {
	// 비어있어도 상관없음. Annotation에서 component scan을 마쳤기떄문이지 ㅎㅎ

}