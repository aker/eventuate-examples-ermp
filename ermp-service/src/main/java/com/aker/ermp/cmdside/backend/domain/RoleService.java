package com.aker.ermp.cmdside.backend.domain;

import io.eventuate.EntityWithIdAndVersion;

public interface RoleService {

	EntityWithIdAndVersion<RoleAggregate> createRole(String name);
}
