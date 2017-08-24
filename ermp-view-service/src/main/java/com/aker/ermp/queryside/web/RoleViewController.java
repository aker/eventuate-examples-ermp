package com.aker.ermp.queryside.web;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aker.ermp.common.controller.BaseController;
import com.aker.ermp.common.model.ResourceWithUrl;
import com.aker.ermp.model.Role;
import com.aker.ermp.queryside.backend.domain.RoleViewServiceImpl;

@RestController
@RequestMapping(value = "/roles")
public class RoleViewController extends BaseController {
	
	@Autowired
	private RoleViewServiceImpl roleViewService;
	
	@RequestMapping(method = GET)
	public HttpEntity<Collection<ResourceWithUrl>> listAll() {
		List<ResourceWithUrl> resourceWithUrls = roleViewService.getAll().stream().map(this::toResource).collect(Collectors.toList());
		return new ResponseEntity<>(resourceWithUrls, OK);
	}

	protected ResourceWithUrl toResource(Role role) {
		ResourceWithUrl<Role> result = new ResourceWithUrl<>(role);
		
		return result;
	}
}