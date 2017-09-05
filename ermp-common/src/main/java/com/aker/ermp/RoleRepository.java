package com.aker.ermp;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aker.ermp.model.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}
