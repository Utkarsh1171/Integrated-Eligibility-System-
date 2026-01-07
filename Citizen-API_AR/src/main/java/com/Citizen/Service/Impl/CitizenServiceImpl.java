package com.Citizen.Service.Impl;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Citizen.Dto.CitizenDto;
import com.Citizen.Entity.CitizenApplication;
import com.Citizen.Entity.User;
import com.Citizen.Exception.UserNotFoundThisId;
import com.Citizen.Repository.CitizenApplicationRepo;
import com.Citizen.Repository.PlanMasterRepo;
import com.Citizen.Repository.UserRepo;
import com.Citizen.Service.Citizenservice;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j 
public class CitizenServiceImpl implements Citizenservice {
	@Autowired
   private CitizenApplicationRepo repo;
	@Autowired
	private PlanMasterRepo planMasterRepo;
	@Autowired
	private UserRepo userrepo;
	@Override
	public boolean createApplication(CitizenDto citizenDto) {
		

        if (!isFromRhodeIsland(citizenDto.getSsn())) {
        	
            return false;
        } 
        CitizenApplication citizen = repo.findBySsn(citizenDto.getSsn());
        // Find User
        User user = userrepo.findByEmail(citizenDto.getEmail().trim());
        if (user == null) {
            throw new RuntimeException("User not found with email: " + citizenDto.getEmail());
        }
        // SSN EXISTS – validate user
        if (citizen != null) {
            if (!citizen.getUser().getUserId().equals(user.getUserId())) {
                throw new RuntimeException(
                    "SSN already registered with another user: " + citizenDto.getSsn()
                );
            }
        }
        // Map DTO → Entity
        ModelMapper model = new ModelMapper();
        CitizenApplication cap = model.map(citizenDto, CitizenApplication.class);

        // Set user
        cap.setUser(user);
      com.Citizen.Entity.PlanMaster plan= planMasterRepo.findByPlanName(citizenDto.getPlanName());
        if (plan == null) {
            throw new RuntimeException("Plan not found: " + citizenDto.getPlanName());
        }
        cap.setPlan(plan);

        // Save record
        repo.save(cap);
        return true;
    }
	public boolean isFromRhodeIsland(long ssnLong) {

	    // Convert long to 9-digit string with leading zeros
	    String ssn = String.format("%09d", ssnLong);

	    // Extract first 3 digits (area number)
	    String area = ssn.substring(0, 3);

	    return area.equals("035") || area.equals("036");
	}

	@Override
	public CitizenApplication getApp(Integer appNum) {
		CitizenApplication app = repo.findById(appNum)
			    .orElseThrow(() -> new RuntimeException("Application not found with ID: " + appNum));
			return app;

	}

	@Override
	public List<CitizenApplication> getApps() {
		List<CitizenApplication> applications = repo.findAll();
		if (applications.isEmpty()) {
	        throw new RuntimeException("No applications found");
	    }

	    return applications;
	}

	@Override
	public CitizenApplication getAppWithCitizenId(Integer citizenId) {
		User user = userrepo.findById(citizenId).orElseThrow(() -> new UserNotFoundThisId("Citizen id invalid"));
		CitizenApplication citizen = repo.findByUser(user).orElseThrow(() -> new UserNotFoundThisId("Citizen id invalid"));;
		return citizen;
	}
	}

