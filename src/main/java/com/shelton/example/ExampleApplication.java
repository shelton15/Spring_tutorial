package com.shelton.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(ExampleApplication.class, args);

		MyFirstClass myFirstClass = ctx.getBean("myBean",MyFirstClass.class);
//		System.out.println(myFirstClass.sayHello());
	}

}
