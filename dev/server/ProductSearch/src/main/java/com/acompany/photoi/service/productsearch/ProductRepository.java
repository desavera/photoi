package com.acompany.photoi.service.productsearch;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  {
	Product findById(Integer id);
	List<Product> findAll();		              
	List<Product> findByQueryParam(ProductQuery query);	
}