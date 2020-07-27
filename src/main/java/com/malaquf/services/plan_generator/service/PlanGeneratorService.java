package com.malaquf.services.plan_generator.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.malaquf.services.plan_generator.dto.BorrowerPayment;

/**
 * Plan generator service.
 */
public interface PlanGeneratorService {

	/**
	 * Generates repayment plans throughout the lifetime of a loan.
	 * @param loanAmount Principal amount.
	 * @param nominalRate Annual interest rate.
	 * @param duration Number of installments in months.
	 * @param startDate Date of Disbursement/Payout.
	 * @return Repayment plan for an annuity loan.
	 */
	List<BorrowerPayment> generateBorrowerPayments(BigDecimal loanAmount, BigDecimal nominalRate, Integer duration, Date startDate);
	
}
