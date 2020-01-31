package com.secondstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.secondstore.domain.UserPayment;

public interface UserPaymentRepository extends CrudRepository<UserPayment, Long>{

	UserPayment findOne(Long id);

	void delete(Long id);

	

}
