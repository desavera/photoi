package com.acompany.photoi.service.payment;

import java.util.Date;
import java.util.List;
import java.util.Comparator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface PaymentRequestRepository {	
	List<PaymentRequest> findAll();
	PaymentRequest findById(Integer paymentId) throws PaymentRequestNotFoundException;
	void delete(PaymentRequest payed) throws PaymentRequestNotFoundException;
	void save(PaymentRequest payment);

}