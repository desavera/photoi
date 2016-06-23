package com.acompany.photoi.service.productsearch;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  {
	
	List<Product> findAll();		              
	
}