package com.acompany.photoi.service.productsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryMockImpl implements ProductRepository {
	
	
	private Map<Integer,Product> repoMap = new HashMap();
	
	public ProductRepositoryMockImpl() {
		repoMap.put(1,new Product(1,"photo1"));
	}
	
	@Override
	public List<Product> findAll() {
		return new ArrayList<Product>(repoMap.values());	}

}