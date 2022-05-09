package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.entity.UserModel;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class HomeController {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	
	@PostMapping("/register")
	public User userRegister(@RequestBody UserModel userModel) {
		
		User newUser = new User();
		newUser.setEmail(userModel.getEmail());
		newUser.setPassword(encoder.encode(userModel.getPassword()));
		
		return repository.save(newUser);
		
		
		
	}
	
	
	@GetMapping("/home")
	public String home() {
		
		return "This is User home page ?";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		
		return "This is User dashboard page ?";
	}

}
