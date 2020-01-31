package com.secondstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.secondstore.domain.CartItem;
import com.secondstore.domain.ProductsToCartItem;

public interface ProductsToCartItemRepository extends CrudRepository<ProductsToCartItem, Long>{

	void deleteByCartItem(CartItem cartItem);

	
}
