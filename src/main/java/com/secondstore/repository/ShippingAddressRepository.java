package com.secondstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.secondstore.domain.ShippingAddress;

public interface ShippingAddressRepository extends CrudRepository<ShippingAddress, Long> {

}
