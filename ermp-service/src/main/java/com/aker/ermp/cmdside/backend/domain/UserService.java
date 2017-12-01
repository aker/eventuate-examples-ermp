package com.aker.ermp.cmdside.backend.domain;

import io.eventuate.EntityWithIdAndVersion;

public interface UserService {

	EntityWithIdAndVersion<UserAggregate> createUser(String userCode, String userName, String password, String email);
}
