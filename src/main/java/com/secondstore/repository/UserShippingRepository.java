package com.secondstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.secondstore.domain.UserShipping;

public interface UserShippingRepository extends CrudRepository<UserShipping, Long> {

	void delete(Long id);

	UserShipping findOne(Long id);

}
