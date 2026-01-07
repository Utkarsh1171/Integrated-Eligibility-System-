package com.DC.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "dc_income_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DCIncome {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "income_id")
	    private Integer incomeId;

	    @Min(0)
	    @Column(name = "salary_income", nullable = false)
	    private Integer salaryIncome;

	    @Min(0)
	    @Column(name = "property_income", nullable = false)
	    private Integer propertyIncome;

	    // Many incomes belong to one CitizenApplication
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "app_number", nullable = false)
	    @JsonIgnore
	    private CitizenApplication citizenApplication;
	}


