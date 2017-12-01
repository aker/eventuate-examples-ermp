package com.aker.ermp.queryside.backend.domain;

import java.util.List;

import com.aker.ermp.UserRepository;
import com.aker.ermp.model.UserAccount;

public class UserViewServiceImpl {
	
	private UserRepository repository;
	
	public UserViewServiceImpl(UserRepository repository) {
		this.repository = repository;
	}
	
	public UserAccount save(UserAccount user) {
		return repository.save(user);
	}
	
	public List<UserAccount> getAll() {
		return repository.findAll();
	}
	
    public UserAccount findById(String userId) {
    	UserAccount res = repository.findOne(userId);
    	
    	return res;
    }
}