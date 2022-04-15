package com.sbi.project.layer5;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/greetings")
public class GreetingController {
	
	@RequestMapping("/greet") // // http://localhost:8080/greetings/greet
	public String greetingMessage() {
		return "<h1>Welcome to Spring Web Rest based application</h1>";
	}
	
	@RequestMapping("/boot") // // http://localhost:8080/greetings/greet
	public String welcomeMessage() {
		return "<h2>Welcome to Spring Boot apps</h2>";
	}
	
	@RequestMapping("/web") // // http://localhost:8080/greetings/greet
	public String regardsgMessage() {
		return "<h3>Welcome to Spring Web Apps</h3>";
	}
}
