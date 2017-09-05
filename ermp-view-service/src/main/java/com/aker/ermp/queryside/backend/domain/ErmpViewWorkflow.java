package com.aker.ermp.queryside.backend.domain;

import com.aker.ermp.common.event.RoleCreatedEvent;
import com.aker.ermp.model.Role;

import io.eventuate.DispatchedEvent;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;

@EventSubscriber(id = "ermpViewWorkflow")
public class ErmpViewWorkflow {
	
	private RoleViewServiceImpl roleViewService;
	
	public ErmpViewWorkflow(RoleViewServiceImpl roleViewService) {
		this.roleViewService = roleViewService;
	}
	
	@EventHandlerMethod
	public void create(DispatchedEvent<RoleCreatedEvent> de) {
		Role role = new Role(de.getEvent().getName());
		role.setId(de.getEntityId());
		
		roleViewService.save(role);
	}
}