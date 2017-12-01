package com.aker.ermp.queryside.backend.domain;

import com.aker.ermp.common.event.RoleCreatedEvent;
import com.aker.ermp.common.event.UserCreatedEvent;
import com.aker.ermp.model.Role;
import com.aker.ermp.model.UserAccount;

import io.eventuate.DispatchedEvent;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;

@EventSubscriber(id = "ermpViewWorkflow")
public class ErmpViewWorkflow {
	
	private RoleViewServiceImpl roleViewService;
	private UserViewServiceImpl userViewService;
	
	public ErmpViewWorkflow(UserViewServiceImpl userViewService, RoleViewServiceImpl roleViewService) {
		this.userViewService = userViewService;
		this.roleViewService = roleViewService;
	}
	
	@EventHandlerMethod
	public void create(DispatchedEvent<RoleCreatedEvent> de) {
		Role role = new Role(de.getEvent().getName());
		role.setId(de.getEntityId());
		
		roleViewService.save(role);
	}
	
	@EventHandlerMethod
	public void createUser(DispatchedEvent<UserCreatedEvent> de) {
		UserCreatedEvent event = de.getEvent();
		UserAccount user = new UserAccount(de.getEntityId(), event.getUserCode(), event.getUserName(), event.getPassword(), event.getEmail());
		
		userViewService.save(user);
	}
}