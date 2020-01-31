package com.secondstore.service;

import com.secondstore.domain.UserPayment;

public interface UserPaymentService {
UserPayment findById(Long id);
	
	void removeById(Long id);

}
