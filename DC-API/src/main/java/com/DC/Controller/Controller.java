package com.DC.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DC.DTO.EducationDto;
import com.DC.DTO.IncomeDto;
import com.DC.DTO.KidsDto;
import com.DC.DTO.SummaryResponseDto;
import com.DC.Service.DcService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/DC")
public class Controller {

    @Autowired
    private DcService dcService;

    @PostMapping("/income/{appNum}/{userId}")
    public ResponseEntity<?> saveIncome(
            @Valid @RequestBody IncomeDto income,
            @PathVariable("appNum") Integer appNum,
            @PathVariable("userId") Integer userId) {

    	log.info("DTO: {}", income);

        boolean isSaved = dcService.saveIncome(income, appNum, userId);

        if (isSaved) {
            return new ResponseEntity<>("Income saved", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Income not saved", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
        // SAVE EDUCATION
        @PostMapping("/Education/{appNum}/{userId}")
        public ResponseEntity<?> saveEducation(
                @Valid @RequestBody EducationDto education,
                @PathVariable Integer appNum,
                @PathVariable Integer userId) {

            log.info("Education DTO: {}", education);

            boolean saved = dcService.saveEducation(education, appNum, userId);

            if (saved) {
                return new ResponseEntity<>("Education saved", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Education not saved", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        // SAVE KIDS
        @PostMapping("/Kids/{appNum}/{userId}")
        public ResponseEntity<?> saveKids(
                @Valid @RequestBody KidsDto kidsDto,
                @PathVariable Integer appNum,
                @PathVariable Integer userId) {

            log.info("Kids DTO: {}", kidsDto);

            boolean saved = dcService.saveKids(kidsDto, appNum, userId);

            if (saved) {
                return new ResponseEntity<>("Kids details saved", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Kids details not saved", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        // GET SUMMARY
        @GetMapping("/summary/{appNum}")
        public ResponseEntity<?> getSummary(@PathVariable Integer appNum) {

            log.info("Getting summary for AppNum: {}", appNum);

            SummaryResponseDto summary = dcService.getSummry(appNum);

            return new ResponseEntity<>(summary, HttpStatus.OK);
        }
    }


