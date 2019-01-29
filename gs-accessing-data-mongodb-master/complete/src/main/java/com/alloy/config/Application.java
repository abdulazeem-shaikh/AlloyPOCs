package com.alloy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alloy.repository.CustomerRepository;

@SpringBootApplication(scanBasePackages = {"com.alloy.*" , "com.alloy.controller" })
public class Application {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
