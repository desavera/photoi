package com.acompany.photoi.service.users;


import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {			
	List<User> findAll();
	User findByUserName(String username) throws UserNotFoundException;
	void delete(User user) throws UserNotFoundException;
	void save(User user);	
}