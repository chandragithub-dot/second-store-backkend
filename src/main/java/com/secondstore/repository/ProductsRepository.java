package com.secondstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.secondstore.domain.Products;

public interface ProductsRepository extends CrudRepository<Products, Long>{
	List<Products> findByTitleContaining(String keyword);

}
