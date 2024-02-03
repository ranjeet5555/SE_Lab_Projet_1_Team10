package com.cfp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Nitcof1Application {

	public static void main(String[] args) {
		SpringApplication.run(Nitcof1Application.class, args);
	}

}
