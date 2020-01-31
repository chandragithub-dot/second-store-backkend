package com.secondstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.secondstore.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	User findByEmail(String email);
	User findOne(Long id);
	List<User> findAll();
 
}
