package com.DC.ServiceImpl;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DC.DTO.EducationDto;
import com.DC.DTO.IncomeDto;
import com.DC.DTO.KidsDto;
import com.DC.DTO.SummaryResponseDto;
import com.DC.Entity.DCEducation;
import com.DC.Entity.DCIncome;
import com.DC.Entity.DCKids;
import com.DC.Exception.UserNotFoundThisId;
import com.DC.Repository.ChildRepo;
import com.DC.Repository.CitizenApplicationRepo;
import com.DC.Repository.EducationRepo;
import com.DC.Repository.IncomeRepo;
import com.DC.Repository.UserRepo;
import com.DC.Service.DcService;

import lombok.extern.java.Log;




@Service
public class DcServiceImpl implements DcService{
	
	@Autowired
	public IncomeRepo icr;
	@Autowired
	public ChildRepo cr;
	@Autowired
	public CitizenApplicationRepo car;
	@Autowired
	public EducationRepo er;
	@Autowired
	public UserRepo ur;
	
	
	
	@Override
	public boolean saveIncome(@Valid IncomeDto income, Integer appnum, Integer userId) {
		DCIncome dc= new DCIncome();
		dc.setSalaryIncome(income.getSalaryIncome());
		dc.setPropertyIncome(income.getPropertyIncome());
		
		com.DC.Entity.User user = ur.findById(userId).orElseThrow(()-> new UserNotFoundThisId("User not found"));
		
		 List<com.DC.Entity.CitizenApplication> list=car.findByUser(user).
				 orElseThrow(()-> new UserNotFoundThisId("User not found"));
		 
		 com.DC.Entity.CitizenApplication citizenApp = list.stream().filter(ca -> ca.getAppNumber()==appnum).findFirst().get();
		 dc.setCitizenApplication(citizenApp);
		 DCIncome dcIncome= icr.save(dc);
		 return dcIncome!=null;
	}

	@Override
	public boolean saveEducation(@Valid EducationDto education, Integer appnum, Integer userId) {
		ModelMapper modelMapper= new ModelMapper();
		DCEducation deEducation=modelMapper.map(education, DCEducation.class);
		com.DC.Entity.User user = ur.findById(userId).orElseThrow(()-> new UserNotFoundThisId("User not found"));
		
		 List<com.DC.Entity.CitizenApplication> list=car.findByUser(user).
				 orElseThrow(()-> new UserNotFoundThisId("User not found"));
		 
		 com.DC.Entity.CitizenApplication citizenApp = list.stream().filter(ca -> ca.getAppNumber()==appnum).findFirst().get();
		 deEducation.setCitizenApplication(citizenApp);
		 
		 DCEducation save = er.save(deEducation);
		return save !=null;
		// TODO Auto-generated method stub
	}

	@Override
	public boolean saveKids(@Valid KidsDto kidsDto, Integer appnum, Integer userid) {
		ModelMapper modelMapper= new ModelMapper();
		DCKids kids= modelMapper.map(kidsDto, DCKids.class);
		com.DC.Entity.User user = ur.findById(userid).orElseThrow(()-> new UserNotFoundThisId("User not found"));
		 List<com.DC.Entity.CitizenApplication> list=car.findByUser(user).
				 orElseThrow(()-> new UserNotFoundThisId("User not found"));
		 
		 com.DC.Entity.CitizenApplication citizenApp = list.stream().filter(ca -> ca.getAppNumber()==appnum).findFirst().get();
		 kids.setCitizenApplication(citizenApp);
		 
		
			DCKids save = cr.save(kids);
			return save !=null;
		
	}

	@Override
	public SummaryResponseDto getSummry(Integer appNum) {
		DCEducation dcEducation= er.findByCitizenApplication_AppNumber(appNum);
		System.out.println(dcEducation);
		DCIncome dcIncome= icr.findByCitizenApplication_AppNumber(appNum);
		System.out.println(dcIncome);
        DCKids dcKids= cr.findByCitizenApplication_AppNumber(appNum);
        System.out.println(dcKids);
		
        SummaryResponseDto srd = new SummaryResponseDto();
		srd.setEducationDetails(Arrays.asList(dcEducation));
		srd.setIncomedetails(Arrays.asList(dcIncome));
		srd.setKidsDetails(Arrays.asList(dcKids));
		
		
		return srd;
		
	}

}
