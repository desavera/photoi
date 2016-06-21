package com.acompany.photoi.service.users;


import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class UserRepositoryMockImpl implements UserRepository {

	private Map<String,User> repoMap = new HashMap();
	
	public UserRepositoryMockImpl() {
		
		repoMap.put("photoiuser",new User(1,"photoiuser","user","one","one@photoi.com" ,"photoi123","12345",User.NOTLOGGED));	
	}
	

	@Override
	public List<User> findAll() {

		return (List<User>) repoMap.values();
	}

	@Override
	public User findByUserName(String username) throws UserNotFoundException {
		
		
		User user = repoMap.get(username);
		if (user == null) throw new UserNotFoundException();
		
		return user;
	}

	@Override
	public void delete(User user) throws UserNotFoundException {
		
		User deleted = repoMap.remove(user.getUsername());
		if (deleted == null) 
				throw new UserNotFoundException();
		
	}

	@Override
	public void save(User user) {

		// this will replace an existing value
		repoMap.put(user.getUsername(),user);

	}
	
}