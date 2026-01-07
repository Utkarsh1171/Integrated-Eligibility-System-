package com.admin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.Entity.PlanMaster;

public interface PlanRepo extends JpaRepository<PlanMaster, Integer>{
	

}
