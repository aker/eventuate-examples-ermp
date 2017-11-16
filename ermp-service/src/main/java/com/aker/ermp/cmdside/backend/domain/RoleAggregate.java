package com.aker.ermp.cmdside.backend.domain;

import java.util.List;

import com.aker.ermp.cmdside.backend.command.CreateRoleCommand;
import com.aker.ermp.cmdside.backend.command.RoleCommand;
import com.aker.ermp.common.event.RoleCreatedEvent;

import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;

public class RoleAggregate extends ReflectiveMutableCommandProcessingAggregate<RoleAggregate, RoleCommand> {
	
	private String name;
	private String roleId;
	
	public List<Event> process(CreateRoleCommand cmd) {
		return EventUtil.events(new RoleCreatedEvent(cmd.getName()));
	}
	
	public void apply(RoleCreatedEvent event) {
		this.name = event.getName();
	}
	
	public String getName() {
		return this.name;
	}
}