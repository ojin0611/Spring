package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.ConsolePrinter;
import com.example.Hello;
import com.example.StringPrinter;

//Java Annotation을 이용하여 이 클래스가 xml역할 하도록.
@Configuration
public class AppCtx {

	// xml이므로 Bean만들어야함.
	@Bean
	public Hello hello() {					//<bean id = "hello"  class = "com.example.Hello">와 동일.
		Hello hello = new Hello();				
		hello.setName("Spring");				// <property name = "name"  value = "Spring" />
		hello.setPrinter(this.sPrinter());		//<property name = "printer"  ref = "sPrinter" />
		return hello;
	}

	@Bean
	public StringPrinter sPrinter() {			//<bean  id = "sPrinter"  class = "com.example.StringPrinter" />
		return new StringPrinter();			
	}

	@Bean
	public ConsolePrinter consolePrinter() {		// <bean id = "consolePrinter"  class = "com.example.ConsolePrinter" />
		return new ConsolePrinter();
	}

}
