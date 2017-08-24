package com.aker.ermp.queryside.backend.domain;

import com.aker.ermp.common.event.RoleCreatedEvent;
import com.aker.ermp.model.Role;

import io.eventuate.DispatchedEvent;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;

@EventSubscriber(id = "ermpViewEventHandlers")
public class ErmpViewEventSubscriber {
	
	private RoleViewServiceImpl roleViewService;
	
	public ErmpViewEventSubscriber(RoleViewServiceImpl roleViewService) {
		this.roleViewService = roleViewService;
	}
	
	@EventHandlerMethod
	public void create(DispatchedEvent<RoleCreatedEvent> de) {
		Role role = new Role(de.getEvent().getRoleInfo());
		role.setId(de.getEntityId());
		
		roleViewService.save(role);
	}
}