package com.acompany.photoi.service.users;


import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepository {			
	List<User> findAll();
	User findByUserName(String username) throws UserNotFoundException;
	void delete(User user) throws UserNotFoundException;
	void save(User user);	
}