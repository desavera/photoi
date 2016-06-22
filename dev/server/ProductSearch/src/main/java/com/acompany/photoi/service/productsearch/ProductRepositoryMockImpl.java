package com.acompany.photoi.service.productsearch;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryMockImpl implements ProductRepository {
	
	@Override
	public Product findById(Integer id) {
		return null;
	}
	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByQueryParam(ProductQuery query) {
		// TODO Auto-generated method stub
		return null;
	}
}