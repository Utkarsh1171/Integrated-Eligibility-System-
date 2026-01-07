package com.DC.DTO;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class KidsDto {
	
	@NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "kid_name", nullable = false)
    private String kidName;

    @Past
    @Column(name = "kid_dob", nullable = false)
    private LocalDate kidDob;

    @Column(name = "kid_ssn", unique = true, nullable = false)
    private Long kidSsn;

}
