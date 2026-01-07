package com.admin.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.admin.Dto.PlanDto;
import com.admin.Entity.ActiveStatus;
import com.admin.Entity.PlanMaster;
import com.admin.Exception.PlanDoesNotExist;
import com.admin.Repository.PlanRepo;
import com.admin.Service.PlanService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public  class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepo pr;

    @Autowired
    private ModelMapper modelMapper;   // GOOD PRACTICE: use bean

    @Override
    public boolean savePlan(PlanDto planDto) {

        log.info("Plan Service Dto :: " + planDto);

        PlanMaster planmaster = modelMapper.map(planDto, PlanMaster.class);

        log.info("Plan Master :: " + planmaster);

        PlanMaster saved = pr.save(planmaster);

        return saved.getPlanId() != null;
    }

    @Override
    public List<PlanDto> getPlans() {

        List<PlanMaster> allPlans = pr.findAll();

        // FIXED: added mapping function
        List<PlanDto>listDtos=allPlans.stream()
                .map(plan -> modelMapper.map(plan, PlanDto.class))
                .collect(Collectors.toList());
        log.info("List of All Plans::"+ listDtos);
        return listDtos;
    }

    @Override
    public PlanDto getPlan(Integer planId) {

        PlanMaster pm = pr.findById(planId)
                .orElseThrow(() -> new PlanDoesNotExist("Plan Does Not Exist with ID"));

        PlanDto planDto= modelMapper.map(pm, PlanDto.class);
        return planDto;
    }

    @Override
    public boolean updatePlan(Integer planId, String status) {

        PlanMaster pMaster = pr.findById(planId)
                .orElseThrow(() -> new PlanDoesNotExist("Plan Does Not Exist with this ID"));

     if (status.equalsIgnoreCase("y")) {
    	 pMaster.setActiveSw(ActiveStatus.Y);
    	 pr.save(pMaster);
    	 return true;
		
	} else {
		pMaster.setActiveSw(ActiveStatus.N);
		pr.save(pMaster);
		return true;

	}
    }


	@Override
	public void generatePdf() {
		// TODO Auto-generated method stub
		
	}

	
}
