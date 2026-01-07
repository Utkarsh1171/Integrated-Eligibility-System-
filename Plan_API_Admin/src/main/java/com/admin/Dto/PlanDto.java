package com.admin.Dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.admin.Entity.ActiveStatus;

import lombok.Data;

@Data
public class PlanDto {

    @NotBlank(message = "Plan Name is Mandatory")
    @Size(min = 3, max = 100, message = "Plan Name must be 3 and 100 characters")
    private String planName;

    @NotNull(message = "Plan start date is required")
    private LocalDate planStartDate;

    @NotNull(message = "Plan end date is required")
    private LocalDate planEndDate;

    @Size(max = 255, message = "Comments cannot be more than 255 characters")
    private String comments;

    @NotNull(message = "Plan status is required (Y or N)")
    private ActiveStatus activeSw;
}
