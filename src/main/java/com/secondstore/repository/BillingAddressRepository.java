package com.secondstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.secondstore.domain.BillingAddress;

public interface BillingAddressRepository extends CrudRepository<BillingAddress, Long> {

}
