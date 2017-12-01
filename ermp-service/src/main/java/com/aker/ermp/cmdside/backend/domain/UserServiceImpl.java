package com.aker.ermp.cmdside.backend.domain;

import com.aker.ermp.cmdside.backend.command.CreateUserCommand;
import com.aker.ermp.cmdside.backend.command.UserCommand;

import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.sync.AggregateRepository;

public class UserServiceImpl implements UserService {
	
	private final AggregateRepository<UserAggregate, UserCommand> aggregateRepository;
	
	public UserServiceImpl(AggregateRepository<UserAggregate, UserCommand> userRepository) {
		this.aggregateRepository = userRepository;
	}
	
	@Override
	public EntityWithIdAndVersion<UserAggregate> createUser(String userCode, String userName, String password, String email) {
		return aggregateRepository.save(new CreateUserCommand(userCode, userName, password, email));
	}
}