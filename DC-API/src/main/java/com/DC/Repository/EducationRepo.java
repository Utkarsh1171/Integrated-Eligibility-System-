package com.DC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DC.Entity.DCEducation;

public interface EducationRepo extends JpaRepository<DCEducation, Integer> {
	DCEducation findByCitizenApplication_AppNumber(Integer appNumber);

}
