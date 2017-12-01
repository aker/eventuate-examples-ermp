package com.aker.ermp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aker.ermp.model.UserAccount;

public interface UserRepository extends JpaRepository<UserAccount, String> {

	  List<UserAccount> findByEmail(String email);

	  List<UserAccount> findByEmailAndPassword(String email, String password);
}
