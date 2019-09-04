package com.example.demo.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;

public interface UserImpl{
	List<User> getUsers();
	
	User getUser(int userId);

	User addUser(User user);

	User updateUser(User user);
	
	User deleteUser(int userId);
}
