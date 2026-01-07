package com.Citizen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Citizen.Entity.PlanMaster;
@Repository
public interface PlanMasterRepo extends JpaRepository<PlanMaster, Integer>{
	public PlanMaster findByPlanName(String planName);


}
