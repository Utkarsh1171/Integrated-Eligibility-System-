package com.DC.DTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;
 
	@Data
	public class IncomeDto {

	    @NotNull(message = "salaryIncome is required")
	    @Min(value = 0, message = "salaryIncome cannot be negative")
	    private Integer salaryIncome;

	    @NotNull(message = "propertyIncome is required")
	    @Min(value = 0, message = "propertyIncome cannot be negative")
	    private Integer propertyIncome;
}
