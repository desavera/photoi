package com.acompany.photoi.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.acompany.photoi.service.payment.PaymentRequest;
import com.acompany.photoi.service.payment.Sender;
import com.acompany.photoi.service.payment.PaymentApplication;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=PaymentApplication.class)
@WebAppConfiguration
@EnableAutoConfiguration
@IntegrationTest
public class PaymentServiceTest {

	
	
	final Logger logger = Logger.getLogger(PaymentServiceTest.class);

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		factory.setPort(9000);
		factory.setSessionTimeout(10, TimeUnit.MINUTES);
		// factory.addErrorPages(new ErrorPage(HttpStatus.404,
		// "/notfound.html"));
		return factory;
	}

	
   
	@Test
	public void testRequestForFindAllPayment() throws Exception {
	
		
		final String uri = "http://localhost:8080/payment";
		RestTemplate rt = new TestRestTemplate();        
   		
        String result = rt.getForObject(uri, String.class);
        
        logger.debug(result);
	}
	
	@Test
	public void testRequestForCreate() throws Exception {
		
		final String uri = "http://localhost:8080/payment";
		RestTemplate rt = new TestRestTemplate();        
        
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());
        
        PaymentRequest paymentReq = new PaymentRequest(2,new Sender("photoiuser","photoiuser@gmail.com"),"Compra de 2 unidades do produto 1"," ","06/24/207");                           
        PaymentRequest result = rt.postForObject(uri, paymentReq, PaymentRequest.class);
        		
        
        logger.debug(result);
	}
	
	@Test
	public void testRequestForFind() throws Exception {
				
		final String uri = "http://localhost:8080/payment/1";
		RestTemplate rt = new TestRestTemplate();        
        
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());
       
        PaymentRequest result = rt.getForObject(uri,PaymentRequest.class);
        		
        
        logger.debug(result);	
    }
	
	@Test
	public void testRequestForUpdate() throws Exception {
		
		final String uri = "http://localhost:8080/payment";
		RestTemplate rt = new TestRestTemplate();        
        
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());

        
        PaymentRequest paymentReq = new PaymentRequest();
        paymentReq.setId(1);
        rt.put(uri, paymentReq, new HashMap());  		        	
        
        logger.debug("put method executed...");
	}

	@Test
	public void testRequestForDelete() throws Exception {

		final String uri = "http://localhost:8080/pament/1";
		RestTemplate rt = new TestRestTemplate();

		rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		rt.getMessageConverters().add(new StringHttpMessageConverter());

		rt.delete(uri);

		logger.debug("delete method executed...");
	}		
	
 }