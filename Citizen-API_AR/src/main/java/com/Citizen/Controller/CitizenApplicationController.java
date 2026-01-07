package com.Citizen.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Citizen.Dto.CitizenDto;
import com.Citizen.Service.Citizenservice;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("ies/AR")
public class CitizenApplicationController {
	@Autowired
	private Citizenservice citizenservice;
	@PostMapping("/createAPP")
	public ResponseEntity<?>createApplication(@RequestBody CitizenDto citizenDto){
		log.info("CitizenController"+ citizenDto);
		boolean createApplicationResult =citizenservice.createApplication(citizenDto);
		if (createApplicationResult) {
			return new ResponseEntity("Application is created",HttpStatus.OK);
			
		} else {
       return new ResponseEntity("Application is not created", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}
	
	@GetMapping("/getApplication")
	public ResponseEntity<?> getApplication(@RequestParam Integer appNum ){
				 com.Citizen.Entity.CitizenApplication application = citizenservice.getApp(appNum);
				 return new ResponseEntity<>(application, HttpStatus.OK);
	}
    
	@GetMapping("/getall")
	public ResponseEntity<?> getAllApplication( ){
				 List<com.Citizen.Entity.CitizenApplication> application = citizenservice.getApps();
				 return new ResponseEntity<>(application, HttpStatus.OK);
	}
	
	@GetMapping("/findBycitizenId")
	public ResponseEntity<?> getAppWithCitizenId(@RequestParam Integer citizenId){
                 com.Citizen.Entity.CitizenApplication appWithCitizenId = citizenservice.getAppWithCitizenId(citizenId);
		return new ResponseEntity<>(appWithCitizenId, HttpStatus.OK); 

	}
	
	
}
