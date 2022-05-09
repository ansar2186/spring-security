package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	
	@GetMapping("/home")
	public String adminHome() {
		
		
		return "This is Admin home page ?";
	}
	
	@GetMapping("/dashboard")
	public String adminDashboard() {
		
		
		return "This is Admin dashboard page ?";
	}

}
