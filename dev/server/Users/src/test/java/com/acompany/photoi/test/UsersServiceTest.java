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

import com.acompany.photoi.service.users.User;
import com.acompany.photoi.service.users.UsersApplication;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=UsersApplication.class)
@WebAppConfiguration
@EnableAutoConfiguration
@IntegrationTest
public class UsersServiceTest {

	
	
	final Logger logger = Logger.getLogger(UsersServiceTest.class);

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
	public void testRequestForFindAllUsers() throws Exception {
	
		
		final String uri = "http://localhost:8083/users";
		RestTemplate template = new TestRestTemplate();
        String result = template.getForObject(uri, String.class);
        
        logger.debug(result);
	}
	
	@Test
	public void testRequestForLogin() throws Exception {
		
		final String uri = "http://localhost:8083/users/login";
		RestTemplate rt = new TestRestTemplate();        
        
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());

        
        User user = new User();
        user.setUsername("photoiuser");
        user.setPassword("photoi123");
        User result = rt.postForObject(uri, user, User.class);
        		
        
        logger.debug(result);
	}

	@Test
	public void testRequestForLogout() throws Exception {
		
		final String uri = "http://localhost:8083/users/logout";
		RestTemplate rt = new TestRestTemplate();        
        
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());

        
        User user = new User();
        user.setUsername("photoiuser");
        user.setPassword("photoi123");
        User result = rt.postForObject(uri, user, User.class);
        		
        
        logger.debug(result);
	}
	
	@Test
	public void testRequestForFindUser() throws Exception {
		
		final String uri = "http://localhost:8083/users/photoiuser";
		RestTemplate rt = new TestRestTemplate();        
        
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());
       
        User result = rt.getForObject(uri,User.class);
        		
        
        logger.debug(result);
	}
	
	@Test
	public void testRequestForUpdate() throws Exception {
		
		final String uri = "http://localhost:8083/users";
		RestTemplate rt = new TestRestTemplate();        
        
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());

        
        User user = new User();
        user.setUsername("photoiuser");
        user.setPassword("photoi123");
        rt.put(uri, user, new HashMap());  		        	
        
        logger.debug("put method executed...");
	}
		
	@Test
	public void testRequestForDelete() throws Exception {
		
		final String uri = "http://localhost:8083/users/photoiuser";
		RestTemplate rt = new TestRestTemplate();        
        
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());

        rt.delete(uri);  		        	
        
        logger.debug("delete method executed...");
	}
			
	
 }
