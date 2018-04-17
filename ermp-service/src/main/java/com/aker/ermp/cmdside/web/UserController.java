package com.aker.ermp.cmdside.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aker.ermp.cmdside.backend.domain.UserAggregate;
import com.aker.ermp.cmdside.backend.domain.UserService;
import com.aker.ermp.common.CreateUserRequest;
import com.aker.ermp.common.CreateUserResponse;
import com.aker.ermp.common.CreateCustomerRequest;

import io.eventuate.EntityWithIdAndVersion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class UserController {

	private UserService userService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) {
		try {
			EntityWithIdAndVersion<UserAggregate> userAggregate= userService.createUser(createUserRequest.getUserCode(),
					createUserRequest.getUserName(),
					createUserRequest.getPassword(),
					createUserRequest.getEmail());
			return new ResponseEntity<>(new CreateUserResponse(userAggregate.getEntityId()), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public ResponseEntity<CreateUserResponse> createCustomer(@RequestBody CreateCustomerRequest customerRequest) {
		logger.debug("request: {}", customerRequest);
		
		CreateUserRequest userRequest = new CreateUserRequest();
		userRequest.setUserCode(customerRequest.getSsn());
		userRequest.setUserName(customerRequest.getSsn());
		userRequest.setEmail(customerRequest.getEmail());
		userRequest.setPassword(customerRequest.getPassword());

		return createUser(userRequest);
	}
}