package com.DC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DC.Entity.DCKids;

public interface ChildRepo extends JpaRepository<DCKids, Integer>{
	DCKids findByCitizenApplication_AppNumber(Integer appNumber);

}
