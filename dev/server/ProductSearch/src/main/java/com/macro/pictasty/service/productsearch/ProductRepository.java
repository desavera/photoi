package com.macro.pictasty.service.productsearch;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepository  {
	Product findById(Integer id);
	Page<Product> findAll(Pageable pager);		              
	Page<Product> findByQueryParam(ProductQuery query, Pageable pager);	
}