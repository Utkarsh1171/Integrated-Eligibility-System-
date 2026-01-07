package com.DC.DTO;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class EducationDto {

	@NotBlank
	@Column(name = "highest_degree", nullable = false)
	private String highestDegree;

	@NotNull
	@Column(name = "grad_year", nullable = false)
	private Integer gradYear;

	@NotBlank
	@Column(name = "uni_name", nullable = false)
	private String uniName;
}
