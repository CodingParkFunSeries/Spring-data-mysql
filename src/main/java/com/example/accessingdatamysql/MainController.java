package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

// Note : User @RestController instead of @Controller
@RestController
@RequestMapping("/demo")
public class MainController {

	@Autowired
	public UserRepository userRepository;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public String addNewUser(@RequestParam String name, @RequestParam String email) {
		User user = new User(name, email);
		userRepository.save(user);
		return "saved";
	}
	
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
}
