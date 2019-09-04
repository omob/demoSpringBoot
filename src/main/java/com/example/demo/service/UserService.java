package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.impl.UserImpl;
import com.example.demo.model.User;

@Component
@Transactional
public class UserService implements UserImpl{

	@Autowired
	EntityManager entity;
		
	private Map<Integer, User> users = new HashMap<Integer, User>();

	public UserService() {
				
		try {
			this.getUsers().forEach(user -> {
				users.put((int) user.getId(), user);
			});		
			
		} catch (Exception e) {
			System.out.println("Error fetching users: " +  e.getMessage());
		}
	}
	
	@Override
	public List<User> getUsers() {
		List<User> fetchUsers = entity.createQuery("SELECT u FROM User u", User.class)
			.getResultList();
		return fetchUsers;
	}

	@Override
	public User getUser(int userId) {
		try {
			return (User) entity.createQuery("SELECT u FROM User u WHERE u.userId = " + userId, User.class)
			.getSingleResult();
		} catch (NoResultException  e) {
			return new User();
		}
	}

	@Override
	public User addUser(User user) {
		user.setUserId(users.size() + 1);
		this.users.put(user.getUserId(), user);
		
		entity.persist(user);
		return user;
	}
	
	@Override
	public User updateUser(User user) {
		if (user.getUserId() > 0) {
			users.put(user.getUserId(), user);
			entity.merge(user);
			return user;
		}
		
		user.setUserId(users.size() + 1);
		
		this.users.put(user.getUserId(), user);
		entity.persist(user);
		return user;
	}

	@Override
	public User deleteUser(int userId) {
		entity.createQuery("DELETE FROM User WHERE userId = " + userId, User.class);
		
		return users.remove(userId);
	}	

}
