package com.aker.ermp.common.event;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = "com.aker.ermp.cmdside.backend.domain.UserAggregate")
public interface UserEvent extends Event {

}