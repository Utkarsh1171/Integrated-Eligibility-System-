package com.admin.Service;

import java.util.List;
import com.admin.Dto.PlanDto;

public interface PlanService {
	public boolean savePlan(PlanDto planDto);
	public List<PlanDto>getPlans();
	public PlanDto getPlan(Integer planId);
	public void generatePdf();
	public boolean updatePlan(Integer planId, String status);
	
	

}
