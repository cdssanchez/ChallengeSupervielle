package com.challenge.supervielle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.challenge.supervielle"})
public class SupervielleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupervielleApplication.class, args);
	}

}
