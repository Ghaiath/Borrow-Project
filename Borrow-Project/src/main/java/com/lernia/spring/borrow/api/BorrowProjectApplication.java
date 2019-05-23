package com.lernia.spring.borrow.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class BorrowProjectApplication{

	public static void main(String[] args) {
		SpringApplication.run(BorrowProjectApplication.class, args);
	}

}
