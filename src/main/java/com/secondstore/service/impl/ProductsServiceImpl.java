package com.secondstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secondstore.domain.Products;
import com.secondstore.repository.ProductsRepository;
import com.secondstore.service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService{
	
	@Autowired
	private ProductsRepository productsRepository;
	
	public List<Products> findAll() {
		List<Products> productsList = (List<Products>) productsRepository.findAll();
		
		List<Products> activeProductsList = new ArrayList<>();
		
		for (Products products : productsList) {
			if(products.isActive()) {
				activeProductsList.add(products);
			}
		}
		
		return activeProductsList;
	}
	
	public Products findOne(Long id) {
		return ((ProductsService) productsRepository).findOne(id);
	}
	
	public Products save(Products products) {
		return productsRepository.save(products);
	}

	public List<Products> blurrySearch(String keyword) {
		List<Products> productsList = productsRepository.findByTitleContaining(keyword);
		
		List<Products> activeProductsList = new ArrayList<>();
		
		for (Products products : productsList) {
			if(products.isActive()) {
				activeProductsList.add(products);
			}
		}
		
		return activeProductsList;
	}
	
	public void removeOne(Long id) {
		productsRepository.deleteById(id);
	}
}