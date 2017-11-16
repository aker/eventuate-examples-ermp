package com.aker.ermp.cmdside.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aker.ermp.cmdside.backend.domain.RoleAggregate;
import com.aker.ermp.cmdside.backend.domain.RoleService;
import com.aker.ermp.common.CreateRoleRequest;
import com.aker.ermp.common.CreateRoleResponse;

import io.eventuate.EntityWithIdAndVersion;

@RestController
public class RoleController {

	private RoleService roleService;
	
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@RequestMapping(value = "/roles", method = RequestMethod.POST)
	public ResponseEntity<CreateRoleResponse> createRole(@RequestBody CreateRoleRequest createRoleRequest) {
		try {
			EntityWithIdAndVersion<RoleAggregate> roleAggregate= roleService.createRole(createRoleRequest.getName());
			return new ResponseEntity<>(new CreateRoleResponse(roleAggregate.getEntityId()), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}