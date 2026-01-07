package com.Citizen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Citizen.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	  User findByEmail(String email);
}
