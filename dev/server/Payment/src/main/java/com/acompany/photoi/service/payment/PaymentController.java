package com.acompany.photoi.service.payment;

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
public class PaymentController {
	
    @Autowired
    private PaymentRequestRepository paymentRequestRepo;
    
	final Logger logger = Logger.getLogger(PaymentController.class); 
   
        
    
    @RequestMapping(value="/Payments" , method=RequestMethod.GET,
    consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = MediaType.APPLICATION_JSON_VALUE)    
    public List<PaymentRequest> findAllPayments() { 
    	
    	List<PaymentRequest> entities = paymentRequestRepo.findAll();
        return entities;
    }

    @RequestMapping(value="/users" , method=RequestMethod.POST,
	consumes = {MediaType.APPLICATION_JSON_VALUE},
	produces = MediaType.APPLICATION_JSON_VALUE)    
    public PaymentRequest createPaymentRequest(@RequestBody PaymentRequest paymentReq) {    	
    	
		try {
			PaymentRequest paymentRequestFound = paymentRequestRepo.findById(paymentReq.getId());
		} catch (PaymentRequestNotFoundException e) {
			
			// this is a new user then
			paymentRequestRepo.save(paymentReq);
			logger.error("PaymentRequest created : " + paymentReq);
			
			return paymentReq;				
		}

		logger.error("Invalid payment request supplied : " + paymentReq);					
		return paymentReq;
    }
    
    
    
    @RequestMapping(value="/users/{paymentId}" , method=RequestMethod.GET)
    public PaymentRequest findPayment(@PathVariable(value="paymentId") Integer paymentId) {    	
    	
        PaymentRequest paymentRequestFound = new PaymentRequest();
		try {
			paymentRequestFound = paymentRequestRepo.findById(paymentId);
		} catch (PaymentRequestNotFoundException e) {
			
			logger.error("Payment not found : " + paymentId);
		}

        return paymentRequestFound;
    }
    
    

    
    @RequestMapping(value="/payment" , method=RequestMethod.PUT,
	consumes = {MediaType.APPLICATION_JSON_VALUE},
	produces = MediaType.APPLICATION_JSON_VALUE)    
    public void updateUser(@RequestBody PaymentRequest paymentReq) {    	
    	
        PaymentRequest paymentRequestFound = new PaymentRequest();
		try {
			paymentRequestFound = paymentRequestRepo.findById(paymentReq.getId());
		} catch (PaymentRequestNotFoundException e) {
			logger.error("Invalid payment request supplied : " + paymentReq.getId());
		}

		paymentRequestFound.update(paymentReq);
		paymentRequestRepo.save(paymentRequestFound);
		logger.error("PaymentRequest updated : " + paymentRequestFound);

    }
    
    @RequestMapping(value="/payment/{paymentId}" , method=RequestMethod.DELETE,
	consumes = {MediaType.APPLICATION_JSON_VALUE},
	produces = MediaType.APPLICATION_JSON_VALUE)    
    public PaymentRequest deletePayment(@PathVariable(value="paymentId") Integer paymentId) {    	
    	
    	// TODO : return 404 e 400
        PaymentRequest paymentRequestFound = new PaymentRequest();
		try {
			
			paymentRequestFound = paymentRequestRepo.findById(paymentId);
	        paymentRequestRepo.delete(paymentRequestFound);
			
		} catch (PaymentRequestNotFoundException e) {
			
			logger.error("Invalid payment supplied : " + paymentId);
		} 		
        
        return paymentRequestFound;
    }
    
    
}
