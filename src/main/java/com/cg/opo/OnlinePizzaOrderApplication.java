package com.cg.opo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication //Class provides application configuration
@ComponentScan(basePackages="com.cg.opo")
public class OnlinePizzaOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinePizzaOrderApplication.class, args);
		System.out.println("!!!!!!!!!!! Now You Can Order Your Pizza !!!!!!!!!!!");
	}

}
