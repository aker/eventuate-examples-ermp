package com.aker.ermp.queryside.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aker.ermp.model.Role;
import com.aker.ermp.queryside.backend.domain.RoleViewServiceImpl;

@RestController
public class RoleViewController {
	
	private RoleViewServiceImpl roleViewService;
	
	@Autowired
	public RoleViewController(RoleViewServiceImpl roleViewService) {
		this.roleViewService = roleViewService;
	}
	
	@RequestMapping(value = "/roles/{roleId}", method = RequestMethod.GET)
	public Role getRole(@PathVariable String roleId) {
		return roleViewService.findById(roleId);
	}
	
	@RequestMapping(value = "/roles/", method = RequestMethod.GET)
	public List<Role> getAll() {
		return roleViewService.getAll();
	}
}