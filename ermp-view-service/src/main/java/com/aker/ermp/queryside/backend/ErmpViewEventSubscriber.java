package com.aker.ermp.queryside.backend;

import com.aker.ermp.common.event.RoleCreatedEvent;
import com.aker.ermp.model.Role;

import io.eventuate.DispatchedEvent;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;

@EventSubscriber(id = "roleQuerySideEventHandlers")
public class ErmpViewEventSubscriber {
	
	private RoleQueryService roleQueryService;
	
	public ErmpViewEventSubscriber(RoleQueryService roleQueryService) {
		this.roleQueryService = roleQueryService;
	}
	
	@EventHandlerMethod
	public void create(DispatchedEvent<RoleCreatedEvent> de) {
		Role role = new Role(de.getEvent().getRole());
		role.setId(de.getEntityId());
		
		roleQueryService.save(role);
	}
}