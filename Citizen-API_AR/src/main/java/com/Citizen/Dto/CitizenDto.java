package com.Citizen.Dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
@Data
@Slf4j
public class CitizenDto {
	@NotBlank(message = "Fullname is required")
    @Size(min = 3, max = 100, message = "Fullname must be between 3 and 100 characters")
    @Column(name = "fullname", nullable = false, length = 100)
    private String fullname;

    @NotNull(message = "Date of Birth is required")
    @Past(message = "Date of Birth must be in the past")
    @Column(name = "dob", nullable = false)
    private LocalDate dob;

    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female or Other")
    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    @NotNull(message = "SSN is required")
    @Digits(integer = 9, fraction = 0, message = "SSN must be 9 digits")
    @Column(name = "ssn", nullable = false, unique = true)
    private Long ssn;
    
    @NotBlank(message = "Plan Name is Required")
    @Size(min = 3,max = 100,message = "planname must be 3 and 100 characters")
    @Column(name = "plananme",nullable = false,length = 100)
    private String planName;
    
    @NotBlank(message = "Email is required")
	private String email;
}
