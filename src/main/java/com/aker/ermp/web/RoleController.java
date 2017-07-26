package com.aker.ermp.web;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.concurrent.CompletableFuture;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aker.ermp.backend.domain.RoleService;
import com.aker.ermp.common.controller.BaseController;
import com.aker.ermp.model.ResourceWithUrl;
import com.aker.ermp.model.RoleInfo;

@RestController
@RequestMapping(value = "/roles")
public class RoleController extends BaseController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(method = POST)
	public CompletableFuture<ResourceWithUrl> saveRole(@RequestBody RoleInfo role, HttpServletRequest request) {
		Assert.notNull(role.getName());
		return roleService.save(role).thenApply(e -> withRequestAttributeContext(request, () -> toResource(e.getAggregate().getRole(), e.getEntityId())));
	}
	
	protected ResourceWithUrl toResource(RoleInfo role, String id) {
		ResourceWithUrl<RoleInfo> result = new ResourceWithUrl<>(role);
		result.setId(id);
		
		return result;
	}
}