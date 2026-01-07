package com.admin.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.Dto.PlanDto;
import com.admin.Service.PlanService;

import ch.qos.logback.core.status.Status;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody; 
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("plan/admin")
@Tag(name = "Plans-Api")
public class PlanController {
	@Autowired
	private PlanService ps;
	@PostMapping("/createPlan")
    @Operation(description = "Plan Created Only Admin",summary = "Plan Creation")
	public ResponseEntity<?>savePlan(@Valid @RequestBody PlanDto planDto){
		
		log.info("PlanController ::"+ planDto);
		
		boolean savePlanResult=ps.savePlan(planDto);
		
		if (savePlanResult) {
			return new ResponseEntity("Plan Created Sucessfully!",HttpStatus.CREATED);
			
		} else {
			return new ResponseEntity("Plan Not Created",HttpStatus.BAD_REQUEST);

		}
		
	}
	@GetMapping("/getAllPlans")
	@Operation(description = "Fetch all plans", summary = "Get All Plans")
	public ResponseEntity<?> getAllPlans() {

		log.info("PlanController :: getAllPlans");

		return new ResponseEntity<>(ps.getPlans(), HttpStatus.OK);
	}

	// ====================== GET BY ID ===========================
		@GetMapping("/getPlan/{planId}")
		@Operation(description = "Fetch plan using ID", summary = "Get Singel Plan")
		public ResponseEntity<?> getPlanById(@PathVariable Integer planId) {

			log.info("PlanController :: getPlanById :: {}", planId);

			PlanDto plan = ps.getPlan(planId);

			if (plan != null) {
				return new ResponseEntity<>(plan, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Plan Not Found", HttpStatus.NOT_FOUND);
			}
		}

		@PutMapping("/updatePlan/{planId}/{status}")
		@Operation(description = "Update plan by ID", summary = "Update Plan")
		public ResponseEntity<?> updatePlan(@PathVariable Integer planId, @PathVariable String status) {

			log.info("PlanController :: updatePlan :: {}", planId);

			boolean updated = ps.updatePlan(planId, status);

			if (updated) {
				return new ResponseEntity<>("Plan Updated Successfully!", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Plan Not Updated / Not Found", HttpStatus.BAD_REQUEST);
			}
		}
		public ResponseEntity<?>getpdf(){
			ps.generatePdf();
			return new ResponseEntity("Pdf generated",HttpStatus.OK);
		}

}
