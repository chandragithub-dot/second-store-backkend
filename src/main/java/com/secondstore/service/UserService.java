package com.secondstore.service;

import java.util.Set;

import com.secondstore.domain.User;
import com.secondstore.domain.UserBilling;
import com.secondstore.domain.UserPayment;
import com.secondstore.domain.UserShipping;
import com.secondstore.domain.security.UserRole;

public interface UserService {
	
	User createUser(User user, Set<UserRole> userRoles);
	
    User findByUsername(String username);
	
	User findByEmail (String email);
	
	User save(User user);
	
	User findById(Long id);

	void updateUserPaymentInfo(UserBilling userBilling, UserPayment userPayment, User user);

	void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);

	void setUserDefaultPayment(Long userPaymentId, User user);

	void updateUserShipping(UserShipping userShipping, User user);

	void setUserDefaultShipping(Long userShippingId, User user);
	

}
