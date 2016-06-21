package com.macro.pictasty.service.productsearch;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProductRepositoryMockImpl implements ProductRepository {
	
	@Override
	public Product findById(Integer id) {
		return null;
	}
	
	@Override
	public Page<Product> findAll(Pageable pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Product> findByQueryParam(ProductQuery query, Pageable pager) {
		// TODO Auto-generated method stub
		return null;
	}
}