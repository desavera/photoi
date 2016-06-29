package com.acompany.photoi.service.users;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryMockImpl implements UserRepository {

	private Map<String,User> repoMap = new HashMap();
	
	public UserRepositoryMockImpl() {
		
		repoMap.put("photoi",new User(1,"photoi","admin","user","admin@photoi.com" ,"photoi","12345",User.NOTLOGGED));	
		repoMap.put("photoiuser",new User(2,"photoiuser","photoi","user","photoiuser@photoi.com" ,"photoi123","12345",User.NOTLOGGED));	
	}
	

	@Override
	public List<User> findAll() {

		return new ArrayList<User>(repoMap.values());
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
