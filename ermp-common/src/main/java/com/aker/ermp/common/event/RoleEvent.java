package com.aker.ermp.common.event;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = "com.aker.ermp.ermpservice.backend.domain.RoleAggregate")
public interface RoleEvent extends Event {

}
