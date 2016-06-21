package com.acompany.photoi.service.payment;

import java.io.Serializable;

import org.apache.log4j.Logger;



public class Product implements Serializable {

	private final static long serialVersionUID = 1L;

	final Logger logger = Logger.getLogger(Product.class);

	//
	// Data members
	//
	private Integer id;
	private String name;

	//
	// Accessors/Mutators
	//
	public Integer getId() {
		return id;
	}

	public void setId(Integer sch_id) {
		this.id = sch_id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}


	//
	// Methods
	//	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String toString() {

		StringBuffer str = new StringBuffer();
		str.append("Id : " + id + '\n');
		str.append("Origin : " + name + '\n');

		return str.toString();
	}

	public void update(Product product) {
		
		if (product.equals(this))
			this.setName(product.getName());
		
	}

}
