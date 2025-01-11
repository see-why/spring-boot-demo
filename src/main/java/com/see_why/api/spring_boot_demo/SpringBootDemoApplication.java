package com.see_why.api.spring_boot_demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@GetMapping("path")
	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	
	@GetMapping("/")
	public WelcomeMessage welcome() {
		return new WelcomeMessage(
			"Welcome to SpringBoot",
			List.of("C#", "Python", "Ruby")
		);
	}

	@GetMapping
	public List<Customer> getCustomers() {
		return List.of();
	}

}
