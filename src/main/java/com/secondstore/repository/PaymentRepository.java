package com.secondstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.secondstore.domain.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long>{

}
