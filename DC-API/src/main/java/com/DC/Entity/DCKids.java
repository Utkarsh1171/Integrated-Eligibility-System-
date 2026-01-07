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
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dc_kids_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DCKids {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "kid_id")
	    private Integer kidId;

	    @NotBlank
	    @Size(min = 2, max = 50)
	    @Column(name = "kid_name", nullable = false)
	    private String kidName;

	    @Past
	    @Column(name = "kid_dob", nullable = false)
	    private LocalDate kidDob;

	    @Column(name = "kid_ssn", unique = true, nullable = false)
	    private Long kidSsn;

	    // Many kids belong to one CitizenApplication
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "app_number", nullable = false)
	    @JsonIgnore
	    private CitizenApplication citizenApplication;
	}




