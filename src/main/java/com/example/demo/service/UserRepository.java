package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long>{
	User findByUserId(int userId);
	
	@Modifying
	@Query(value = "DELETE FROM User WHERE user_id = :userId", nativeQuery = true)
	void deleteByUserId(int userId);
}
