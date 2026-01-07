package com.DC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DC.Entity.DCIncome;

public interface IncomeRepo extends JpaRepository<DCIncome, Integer> {
	
	DCIncome findByCitizenApplication_AppNumber(Integer appNumber);

}
