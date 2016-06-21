package com.acompany.photoi.service.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
	
    @Autowired
    private PaymentRepository paymentRepo;
    

    @RequestMapping("/payment/{owner_id}")
    public Page<Payment> findPaymentsByOwner(
    		final @RequestParam(defaultValue = "0", required = false) int page,
     	    final @RequestParam(defaultValue = "10", required = false) int pageSize,
     	    @PathVariable(value="owner_id") Integer owner_id) {
    	Pageable topTen = new PageRequest(page, pageSize);
    	Page<Payment> entities = paymentRepo.findByOwner(owner_id,topTen);
        return entities;
    }
    
    @RequestMapping("/payment")
    public Page<Payment> findAllPayments(
    		final @RequestParam(defaultValue = "0", required = false) int page,
     	    final @RequestParam(defaultValue = "10", required = false) int pageSize) { 
    	Pageable pager = new PageRequest(page, pageSize);
    	Page<Payment> entities = paymentRepo.findAll(pager);
        return entities;
    }
}
