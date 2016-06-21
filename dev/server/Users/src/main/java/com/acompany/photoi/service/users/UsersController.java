package com.acompany.photoi.service.users;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UsersController {
	
    @Autowired
    private UserRepository userRepo;

	final Logger logger = Logger.getLogger(UsersController.class); 
   
    
    
    
    
    @RequestMapping(value="/users" , method=RequestMethod.GET,
    consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = MediaType.APPLICATION_JSON_VALUE)    
    public List<User> findAllUsers() { 
    	
    	List<User> entities = userRepo.findAll();
        return entities;
    }

    
    @RequestMapping(value="/users/login" , method=RequestMethod.GET,
	consumes = {MediaType.APPLICATION_JSON_VALUE},
	produces = MediaType.APPLICATION_JSON_VALUE)    
    public User login(@PathVariable(value="username") String username,
    				   @PathVariable(value="password") String password) {    	
    	
    	//TODO : return 404 e 400
    	User userFound = new User();
        try {
			
        	userFound = userRepo.findByUserName(username);
			
        	if (userFound.getPassword().compareTo(password) == 0)
			
        		userFound.setUserStatus(User.LOGGED);
        	
        	else throw new WrongUserPasswordException();
        	
		} catch (UserNotFoundException  e) {
			
			logger.error("User not found : " + username + '\n' + e);
			
		} catch (WrongUserPasswordException e) {
			
			logger.error("User password mismatch ... " + '\n' + e);
		}
        
		
        return userFound;
    }

    
    @RequestMapping(value="/users/logout" , method=RequestMethod.GET,
	consumes = {MediaType.APPLICATION_JSON_VALUE},
	produces = MediaType.APPLICATION_JSON_VALUE)    
    public User logout(@PathVariable(value="user") User user) {    	
    	
    	//TODO : return 404 e 400
    	User userFound = new User();
        try {
			userFound = userRepo.findByUserName(user.getUsername());
			userFound.setUserStatus(User.NOTLOGGED);
		} catch (UserNotFoundException e) {
			
			logger.error("User not found : " + user.getUsername() + '\n' + e);
		}
		
        return userFound;
    }
    
    
    @RequestMapping(value="/users/{userName}" , method=RequestMethod.GET,
	consumes = {MediaType.APPLICATION_JSON_VALUE},
	produces = MediaType.APPLICATION_JSON_VALUE)    
    public User findUser(@PathVariable(value="id") String username) {    	
    	
    	//TODO : return 404 e 400
    	User user = new User();
        try {
			user = userRepo.findByUserName(username);
		} catch (UserNotFoundException e) {
			
			logger.error("User not found : " + username + '\n' + e);
		}
		
        return user;
    }

    
    @RequestMapping(value="/users" , method=RequestMethod.PUT,
	consumes = {MediaType.APPLICATION_JSON_VALUE},
	produces = MediaType.APPLICATION_JSON_VALUE)    
    public User updateUser(@PathVariable(value="user") User user) {    	
    	
        User userFound = new User();
		try {
			userFound = userRepo.findByUserName(user.getUsername());
		} catch (UserNotFoundException e) {
			
			// this is a new user then
			userRepo.save(user);			
		}

		logger.error("User created : " + user.getUsername());
		userFound.update(user);
		userRepo.save(userFound);	
        return userFound;
    }
    

    
    @RequestMapping(value="/users/{username}" , method=RequestMethod.DELETE,
	consumes = {MediaType.APPLICATION_JSON_VALUE},
	produces = MediaType.APPLICATION_JSON_VALUE)    
    public User deleteUser(@PathVariable(value="username") String username) {    	
    	
    	// TODO : return 404 e 400
        User user = new User();
		try {
			
			user = userRepo.findByUserName(username);
	        userRepo.delete(user);
			
		} catch (UserNotFoundException e) {
			
			logger.error("User not found : " + username + '\n' + e);
		} 		
        
        return user;
    }
    
    
}
