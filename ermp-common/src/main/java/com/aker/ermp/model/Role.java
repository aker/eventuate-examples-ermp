package com.aker.ermp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {

    @Id
    private String id;
    @Column
    private String name;
    @Column
    private Boolean deleted;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Role merge(Role newTodo) {
        return new Role(id,
                nonNull(newTodo.name, name));
    }

    private <T> T nonNull(T value, T defaultValue) {
        return value == null ? defaultValue : value;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}