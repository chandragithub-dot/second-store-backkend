package com.secondstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.secondstore.domain.CartItem;
import com.secondstore.domain.ShoppingCart;

public interface CartItemRepository extends CrudRepository<CartItem, Long>{

List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

CartItem findOne(Long id);
	
//	List<CartItem> findByOrder(Order order);
}
