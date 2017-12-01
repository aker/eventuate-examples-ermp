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

import io.eventuate.EntityWithIdAndVersion;

@RestController
public class UserController {

	private UserService userService;
	
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
}