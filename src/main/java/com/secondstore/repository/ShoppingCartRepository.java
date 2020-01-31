package com.secondstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.secondstore.domain.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long>{

}
