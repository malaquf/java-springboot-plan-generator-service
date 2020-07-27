package com.malaquf.services.plan_generator.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
/**
 * Generate plan service request class.
 */
public class GeneratePlanRequest {

	/**
	 * principal amount.
	 */
	private BigDecimal loanAmount;
	/**
	 * annual interest rate.
	 */
	private BigDecimal nominalRate;
	/**
	 * number of installments in months.
	 */
	private Integer duration;
	/**
	 * date of disbursement/payout.
	 */
	private Date startDate;
	
}
