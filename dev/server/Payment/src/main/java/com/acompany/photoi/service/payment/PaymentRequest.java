package com.acompany.photoi.service.payment;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.StringUtils;



public class PaymentRequest implements Serializable {

	private final static long serialVersionUID = 1L;

	//
	// Data members
	//
	private Integer id;
	private Sender sender;
	private String description;
	private String reference;	
	private String date;


	public PaymentRequest(Integer id, Sender sender, String description, String reference, String date) {
		super();
		this.id = id;
		this.sender = sender;
		this.description = description;
		this.reference = reference;
		this.date = date;
	}

	
	
	public PaymentRequest() {
		this(-1,new Sender(),"Error...","Error...","Error...");
	}


	//
	// Accessors/Mutators
	//
	public Integer getId() {
		return id;
	}

	public void setId(Integer res_id) {
		this.id = res_id;
	}

	public Sender getSender() {
		return sender;
	}

	public void setSender(Sender sender) {
		this.sender = sender;
	}

	public String getReference() {
		return reference;
	}



	public void setReference(String reference) {
		this.reference = reference;
	}

	
	
	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
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
		if (!(obj instanceof PaymentRequest))
			return false;
		PaymentRequest other = (PaymentRequest) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public String toString() {
		
		StringBuffer str = new StringBuffer();
		str.append("Id : " + id + '\n');
		str.append("Sender : " + sender + '\n');
		str.append("Description : " + description + '\n');
		str.append("Reference : " + reference + '\n');
		str.append("Date : " + date + '\n');
		
		return str.toString();
	}

	public void update(PaymentRequest paymentRequest) {
		if (paymentRequest.equals(this)) {
			this.id = paymentRequest.getId();
			this.sender = paymentRequest.getSender();
			this.description = paymentRequest.description;
			this.reference = paymentRequest.getReference();
			this.date = paymentRequest.getDate();			
		}
	}
}
