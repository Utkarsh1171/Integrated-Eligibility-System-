package com.Citizen.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Citizen.Entity.CitizenApplication;
import com.Citizen.Entity.User;
@Repository
public interface CitizenApplicationRepo extends JpaRepository<CitizenApplication, Integer> {
	Optional<CitizenApplication> findByUser(User user);

	CitizenApplication findBySsn(Long ssn);


}
