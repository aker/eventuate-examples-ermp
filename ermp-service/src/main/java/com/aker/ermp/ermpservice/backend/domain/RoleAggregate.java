package com.aker.ermp.ermpservice.backend.domain;

import java.util.Collections;
import java.util.List;

import com.aker.ermp.ermpservice.backend.command.CreateRoleCommand;
import com.aker.ermp.ermpservice.backend.command.RoleCommand;
import com.aker.ermp.common.event.RoleCreatedEvent;
import com.aker.ermp.model.RoleInfo;

import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;

public class RoleAggregate extends ReflectiveMutableCommandProcessingAggregate<RoleAggregate, RoleCommand> {
	
	private RoleInfo role;
	private boolean deleted;
	
	public List<Event> process(CreateRoleCommand cmd) {
		if (this.deleted) {
			return Collections.emptyList();
		}
		
		return EventUtil.events(new RoleCreatedEvent(cmd.getRole()));
	}
	
	public void apply(RoleCreatedEvent event) {
		this.role = event.getRole();
	}
	
	public RoleInfo getRole() {
		return role;
	}
}