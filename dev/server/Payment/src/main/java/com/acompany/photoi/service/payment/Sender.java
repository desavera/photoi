package com.acompany.photoi.service.payment;

import java.util.Date;
import java.util.List;

public class Sender {

	//
	// Data members
	//
	private String name;
	private String email;
	
	public Sender(String name, String email) {

		this.name = name;
		this.email = email;
	}

	public Sender() {
		this("Eror...","Error...");
	}

	//
	// Accessors/Mutators
	//
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//
	// Methods
	//	
	public String toString() {
		
		StringBuffer str = new StringBuffer();
		str.append("Name : " + name + '\n');
		str.append("Email : " + email + '\n');
		
		return str.toString();
	}

	
	
}
