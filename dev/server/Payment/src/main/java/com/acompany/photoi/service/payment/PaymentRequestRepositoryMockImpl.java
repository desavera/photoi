package com.acompany.photoi.service.payment;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Comparator;

import org.springframework.stereotype.Repository;


@Repository
public class PaymentRequestRepositoryMockImpl implements PaymentRequestRepository {

	private Map<Integer,PaymentRequest> repoMap = new HashMap();
	
	
	public PaymentRequestRepositoryMockImpl() {
		
		repoMap.put(1,new PaymentRequest(1,new Sender("photoiuser1","photoiuser1@gmail.com"),"Compra de 1 unidade do produto 1"," ","01/01/2001"));
	}
		
	@Override
	public List<PaymentRequest> findAll() {
		return new ArrayList<PaymentRequest>(repoMap.values());
	}

	@Override
	public PaymentRequest findById(Integer paymentId) throws PaymentRequestNotFoundException {
		PaymentRequest paymentRequest = repoMap.get(paymentId);
		if (paymentRequest == null) throw new PaymentRequestNotFoundException();
		
		return paymentRequest;
	}

	@Override
	public void delete(PaymentRequest paymentRequest) throws PaymentRequestNotFoundException {
		
		PaymentRequest deleted = repoMap.remove(paymentRequest);
		if (deleted == null) 
				throw new PaymentRequestNotFoundException();
		
	}

	@Override
	public void save(PaymentRequest paymentRequest) {
		// this will replace an existing value
		repoMap.put(paymentRequest.getId(),paymentRequest);		
	}
	
}