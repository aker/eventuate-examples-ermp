package com.aker.ermp.backend;

import com.aker.ermp.common.event.RoleCreatedEvent;

import io.eventuate.DispatchedEvent;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;

@EventSubscriber(id = "roleQuerySideEventHandlers")
public class RoleQueryWorkflow {
	
	private RoleQueryService roleQueryService;
	
	public RoleQueryWorkflow(RoleQueryService roleQueryService) {
		this.roleQueryService = roleQueryService;
	}
	
	@EventHandlerMethod
	public void create(DispatchedEvent<RoleCreatedEvent> de) {
		Role role = new Role(de.getEvent().getRole());
		role.setId(de.getEntityId());
		
		roleQueryService.save(role);
	}
}