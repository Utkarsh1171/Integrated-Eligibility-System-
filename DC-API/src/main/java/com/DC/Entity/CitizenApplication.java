package com.DC.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;	
	@Entity
	@Table(name = "citizen_apps_tbl")
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public class CitizenApplication {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "app_number")
	    private Integer appNumber;

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

	    // ==============================
	    // Relationships
	    // ==============================

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id", nullable = false)
	    @NotNull(message = "User must be linked with application")
	    private User user;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "plan_id", nullable = false)
	    @NotNull(message = "Plan must be selected for application")
	    private PlanMaster plan;


	    @Column(name = "created_date", updatable = false)
	    private LocalDate createdDate;

	    @Column(name = "updated_date")
	    private LocalDate updatedDate;
	    
	    @NotBlank(message = "Plan Name is Required")
	    @Size(min = 3,max = 100,message = "planname must be 3 and 100 characters")
	    @Column(name = "plananme",nullable = false,length = 100)
	    private String planName;
	    
	    @PrePersist
	    public void onCreate() {
	        this.createdDate = LocalDate.now();
	        this.updatedDate = LocalDate.now();
	    }

	    @PreUpdate
	    public void onUpdate() {
	        this.updatedDate = LocalDate.now();
	    }
	    

	}




