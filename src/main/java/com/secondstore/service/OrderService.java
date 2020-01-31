package com.secondstore.service;

import com.secondstore.domain.BillingAddress;
import com.secondstore.domain.Order;
import com.secondstore.domain.Payment;
import com.secondstore.domain.ShippingAddress;
import com.secondstore.domain.ShoppingCart;
import com.secondstore.domain.User;

public interface OrderService {
	
	Order createOrder(
			ShoppingCart shoppingCart,
			ShippingAddress shippingAddress,
			BillingAddress billingAddress,
			Payment payment,
			String shippingMethod,
			User user
	);

}
