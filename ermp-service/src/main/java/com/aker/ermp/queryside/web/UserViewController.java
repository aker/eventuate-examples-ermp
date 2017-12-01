package com.aker.ermp.queryside.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aker.ermp.model.UserAccount;
import com.aker.ermp.queryside.backend.domain.UserViewServiceImpl;

@RestController
public class UserViewController {
	
	private UserViewServiceImpl userViewService;
	
	@Autowired
	public UserViewController(UserViewServiceImpl userViewService) {
		this.userViewService = userViewService;
	}
	
	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	public UserAccount getUser(@PathVariable String userId) {
		return userViewService.findById(userId);
	}
	
	@RequestMapping(value = "/users/", method = RequestMethod.GET)
	public List<UserAccount> getAll() {
		return userViewService.getAll();
	}
}