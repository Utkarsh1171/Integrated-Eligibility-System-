package com.DC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DC.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	User findByEmail(String username);

}
