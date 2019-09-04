package com.example.demo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.camel.Produce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserRepository;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	UserRepository repo;
	
	@RequestMapping(path = "/users")
	public List<User> getUsers() {
		List<User> users = (List<User>) repo.findAll();
		return users;
	}
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable("userId") int userId) {
		return repo.findByUserId(userId);
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		return repo.save(user);
	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		return repo.save(user);
	}
	
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable("userId") int userId) {
		repo.deleteByUserId(userId);
		
		// Delete All By Id
//		repo.findAll()
//			.forEach(user -> {
//				if (user.getUserId() == userId) {
//					repo.delete(user);
//				}
//			});
//		
		return "deleted";
		
	}
}
