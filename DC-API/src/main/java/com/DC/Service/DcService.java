package com.DC.Service;

import javax.validation.Valid;

import com.DC.DTO.EducationDto;
import com.DC.DTO.IncomeDto;
import com.DC.DTO.KidsDto;
import com.DC.DTO.SummaryResponseDto;

public interface DcService {
	
	boolean saveIncome(@Valid IncomeDto income,Integer appnum,Integer userId);
	boolean saveEducation(@Valid EducationDto education,Integer appnum,Integer userId);
	boolean saveKids(@Valid KidsDto kidsDto, Integer appnum, Integer userid);

	SummaryResponseDto getSummry(Integer appNum);
	

}
