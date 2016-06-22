package com.acompany.photoi.service.productsearch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class ProductQuery {

	
	// the default date format
	public final static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	final static Logger logger = Logger.getLogger(ProductQuery.class); 

		
	
	private String name;	

	
	
	public ProductQuery() {
		
	}
	
	public ProductQuery(String name) {
		this.name = name.toString();
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toString();
	}
	
	//
	// Methods
	//
	
	// for debugging purposes
	public String toString() {
	
		StringBuffer str = new StringBuffer();		
		str.append("Name : " + name + '\n');
		
		
		return str.toString();
	}


}
