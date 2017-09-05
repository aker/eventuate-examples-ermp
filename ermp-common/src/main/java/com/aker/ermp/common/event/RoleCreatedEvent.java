package com.aker.ermp.common.event;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class RoleCreatedEvent implements RoleEvent {
	
	private String name;

	private RoleCreatedEvent() {
	}
	
	public RoleCreatedEvent(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
	    return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
	    return HashCodeBuilder.reflectionHashCode(this);
	}
}