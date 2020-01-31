package com.secondstore.service;

import com.secondstore.domain.ShoppingCart;

public interface ShoppingCartService {
	
    ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);
	
	void clearShoppingCart(ShoppingCart shoppingCart);

}
