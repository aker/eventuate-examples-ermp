package com.aker.ermp.cmdside.backend.domain;

import java.util.List;

import com.aker.ermp.cmdside.backend.command.CreateUserCommand;
import com.aker.ermp.cmdside.backend.command.UserCommand;
import com.aker.ermp.common.event.UserCreatedEvent;

import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;

public class UserAggregate extends ReflectiveMutableCommandProcessingAggregate<UserAggregate, UserCommand> {
	
	private String userId;
	private String userCode;
	private String userName;
	private String password;
	private String email;
	
	public List<Event> process(CreateUserCommand cmd) {
		return EventUtil.events(new UserCreatedEvent(cmd.getUserId(), cmd.getUserCode(), cmd.getUserName(), cmd.getPassword(), cmd.getEmail()));
	}
	
	public void apply(UserCreatedEvent event) {
		this.userId = event.getUserId();
		this.userCode = event.getUserCode();
		this.userName = event.getUserName();
		this.password = event.getPassword();
		this.email = event.getEmail();
	}

	public String getUserId() {
		return userId;
	}

	public String getUserCode() {
		return userCode;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}
}