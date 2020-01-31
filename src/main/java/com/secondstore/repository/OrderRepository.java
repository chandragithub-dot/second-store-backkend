package com.secondstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.secondstore.domain.Order;
import com.secondstore.domain.User;

public interface OrderRepository extends CrudRepository<Order, Long>{
	
	List<Order> findByUser(User user);

}
