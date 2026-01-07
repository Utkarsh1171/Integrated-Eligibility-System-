package com.DC.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DC.Entity.CitizenApplication;
import com.DC.Entity.User;

public interface CitizenApplicationRepo extends JpaRepository<CitizenApplication, Integer>{
	Optional<List<CitizenApplication>> findByUser(User user);


}
