package com.team7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmtApplication.class, args);
	}

//	@PostConstruct
//	public static void seedData() {
//
//	}
}
