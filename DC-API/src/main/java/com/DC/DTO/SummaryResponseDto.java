package com.DC.DTO;

import java.util.List;

import com.DC.Entity.DCEducation;
import com.DC.Entity.DCIncome;
import com.DC.Entity.DCKids;

import lombok.Data;
@Data
public class SummaryResponseDto {
  List<DCEducation> EducationDetails;
  List<DCIncome> Incomedetails;
  List<DCKids> kidsDetails;
  
}
