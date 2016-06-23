package com.acompany.photoi.service.payment;

import java.util.Date;
import java.util.List;
import java.util.Comparator;


import org.springframework.stereotype.Repository;


@Repository
public interface PaymentRequestRepository {	
	List<PaymentRequest> findAll();
	PaymentRequest findById(Integer paymentId) throws PaymentRequestNotFoundException;
	void delete(PaymentRequest payed) throws PaymentRequestNotFoundException;
	void save(PaymentRequest payment);

}