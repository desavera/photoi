package com.macro.pictasty.service.productsearch;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    
    @RequestMapping(value="/psearch" , method=RequestMethod.POST,
		    		consumes = {MediaType.APPLICATION_JSON_VALUE},
		    		produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Product> findProductsByQueryParam(
    		final @RequestParam(defaultValue = "0", required = false) int page,
     	    final @RequestParam(defaultValue = "10", required = false) int pageSize,
     	    @RequestBody ProductQuery query) {
    	
		logger.debug("Quering schedules for : " + '\n' + query);

		Pageable pager = new PageRequest(page, pageSize);

		Page<Product> matchList = productRepo.findByQueryParam(query,pager);

		return matchList;

    }    

    @RequestMapping(value="/psearch", method=RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product) {    	
    	Product entity = productRepo.findById(product.getId());
    	
    	entity.update(product);
    		
    	
        return entity;
    }       
    
    
    @RequestMapping("/psearch")
    public Page<Product> findAllSchedules(
    		final @RequestParam(defaultValue = "0", required = false) int page,
     	    final @RequestParam(defaultValue = "10", required = false) int pageSize) {
    	Pageable pager = new PageRequest(page, pageSize);
    	Page<Product> entities = productRepo.findAll(pager);
        return entities;
    }
}
