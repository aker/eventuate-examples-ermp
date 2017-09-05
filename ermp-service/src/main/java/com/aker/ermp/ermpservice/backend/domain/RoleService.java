package com.aker.ermp.ermpservice.backend.domain;

import io.eventuate.EntityWithIdAndVersion;

public interface RoleService {

	EntityWithIdAndVersion<RoleAggregate> createRole(String name);
}
