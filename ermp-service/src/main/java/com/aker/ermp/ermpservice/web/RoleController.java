package com.aker.ermp.ermpservice.web;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.concurrent.CompletableFuture;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aker.ermp.common.controller.BaseController;
import com.aker.ermp.common.model.ResourceWithUrl;
import com.aker.ermp.ermpservice.backend.domain.RoleService;
import com.aker.ermp.model.RoleInfo;

@RestController
@RequestMapping(value = "/roles")
public class RoleController extends BaseController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(method = POST)
	public CompletableFuture<ResourceWithUrl> saveRole(@RequestBody RoleInfo roleInfo, HttpServletRequest request) {
		Assert.notNull(roleInfo.getName());
		return roleService.save(roleInfo).thenApply(e -> withRequestAttributeContext(request, () -> toResource(e.getAggregate().getRoleInfo(), e.getEntityId())));
	}
	
	protected ResourceWithUrl toResource(RoleInfo roleInfo, String id) {
		ResourceWithUrl<RoleInfo> result = new ResourceWithUrl<>(roleInfo);
		result.setId(id);
		
		return result;
	}
}