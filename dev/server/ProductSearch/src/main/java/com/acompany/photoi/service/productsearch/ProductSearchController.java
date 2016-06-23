package com.acompany.photoi.service.productsearch;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductSearchController {
	
    @Autowired
    private ProductRepository productRepo;
    
	final Logger logger = Logger.getLogger(ProductSearchController.class); 
    
    @RequestMapping("/psearch")
    public List<Product> findAllProducts(
    		final @RequestParam(defaultValue = "0", required = false) int page,
     	    final @RequestParam(defaultValue = "10", required = false) int pageSize) {

    	List<Product> entities = productRepo.findAll();
        return entities;
    }
}
