package com.admin.Entity;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "plan_master_tbl")   // ✅ FIXED table name
@Data
@AllArgsConstructor
@NoArgsConstructor                // ✅ REQUIRED by JPA
@Builder
public class PlanMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id", nullable = false)   // ✅ FIXED column name
    private Integer planId;

    @NotBlank(message = "Plan Name is Mandatory")
    @Size(min = 3, max = 100, message = "Plan Name must be 3 and 100 characters")
    @Column(name = "plan_name", nullable = false) // ✅ FIXED & UNIQUE
    private String planName;

    @NotNull(message = "Plan start date is required")
    @Column(name = "plan_start_date")
    private LocalDate planStartDate;

    @NotNull(message = "Plan end date is required")
    @Column(name = "plan_end_date")
    private LocalDate planEndDate;

    @Size(max = 255, message = "Comments cannot be more than 255 characters")
    @Column(name = "comments")
    private String comments;

    @Column(name = "created_date", updatable = false)
    private LocalDate createdDate;

    @Column(name = "updated_date")
    private LocalDate updatedDate;

    @NotNull(message = "Plan status is required (Y or N)")
    @Enumerated(EnumType.STRING)
    @Column(name = "active_sw")
    private ActiveStatus activeSw;
}
