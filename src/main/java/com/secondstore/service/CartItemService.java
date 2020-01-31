package com.secondstore.service;

import java.util.List;

import com.secondstore.domain.CartItem;
import com.secondstore.domain.Products;
import com.secondstore.domain.ShoppingCart;
import com.secondstore.domain.User;

public interface CartItemService {


	CartItem addProductsToCartItem(Products products, User user, int qty);
	
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
//	List<CartItem> findByOrder(Order order);
	
	CartItem updateCartItem(CartItem cartItem);
	
	void removeCartItem(CartItem cartItem);
	
	CartItem findById(Long id);
	
	CartItem save(CartItem cartItem);
}
