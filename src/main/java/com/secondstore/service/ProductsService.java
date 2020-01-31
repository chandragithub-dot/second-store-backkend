package com.secondstore.service;

import java.util.List;

import com.secondstore.domain.Products;

public interface ProductsService {
	
	List<Products> findAll();
	
	Products findOne(Long id);
	
	Products save(Products products);
	
	List<Products> blurrySearch(String title);
	
	void removeOne(Long id);
}
