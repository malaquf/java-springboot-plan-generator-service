package com.malaquf.services.plan_generator.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for performing common calculations.
 *
 */
public class Calculator {
	
	private static Logger logger = LoggerFactory.getLogger(Calculator.class);
	
	private static BigDecimal DAYS_IN_MONTH = BigDecimal.valueOf(30);
	private static BigDecimal DAYS_IN_YEAR = BigDecimal.valueOf(360);

	private Calculator() {
		//hidden constructor
	}
	
	/**
	 * Calculates annuity for given parameters.
	 * @param duration The duration in months.
	 * @param loanAmount The loan amount.
	 * @param nominalRate The annual nominal rate.
	 * @return the calculated annuity for the given parameters.
	 */
	public static final BigDecimal calculateAnnuity(Integer duration, BigDecimal loanAmount, BigDecimal nominalRate) {
		logger.debug("Calculating annuity with duration {} and nominalRate {} for loal amount of {}", duration, loanAmount, nominalRate);
		MathContext mc = new MathContext(32, RoundingMode.HALF_UP);
		BigDecimal rate = calculateMonthlyRate(nominalRate);
		BigDecimal rPv = rate.multiply(loanAmount);
		BigDecimal divisorVar = (BigDecimal.ONE.add(rate, mc)).pow(-duration, mc);
		BigDecimal divisor = BigDecimal.ONE.subtract(divisorVar);
		BigDecimal result = rPv.divide(divisor, mc).setScale(2, RoundingMode.HALF_UP);
		logger.debug("Calculated annuity: {}", result);
		return result;
	}
	
	/**
	 * Calculates the monthly rate for the given annual nominal rate.
	 * @param nominalRate the annual nominal rate to be used for calculation.
	 * @return the monthly rate.
	 */
	public static final BigDecimal calculateMonthlyRate(BigDecimal nominalRate) {
		MathContext mc = new MathContext(32, RoundingMode.HALF_UP);
		return nominalRate.divide(BigDecimal.valueOf(100)).divide(BigDecimal.valueOf(12), mc);
	}
	
	/**
	 * Calculates the interest for given nominal rate and loan amount.
	 * @param nominalRate the annual nominal rate.
	 * @param loanAmount the loan amount.
	 * @return the calculated interest rate.
	 */
	public static final BigDecimal calculateInterest(BigDecimal nominalRate, BigDecimal loanAmount) {
		logger.debug("Calculating interest with nominalRate {} for loal amount of {}", nominalRate, loanAmount);
		MathContext mc = new MathContext(32, RoundingMode.HALF_UP);
		BigDecimal interest = (nominalRate.divide(BigDecimal.valueOf(100)).multiply(DAYS_IN_MONTH).multiply(loanAmount)).divide(DAYS_IN_YEAR, mc);
		BigDecimal result = interest.setScale(2, RoundingMode.HALF_UP);
		logger.debug("Calculated interest: {}", result);
		return result;
	}
	
	/**
	 * Calculates the principal for the given annuity and interest rate.
	 * @param annuity the annuity.
	 * @param interest the interest rate.
	 * @return the calculated principal.
	 */
	public static final BigDecimal calculatePrincipal(BigDecimal annuity, BigDecimal interest) {
		logger.debug("Calculating principal with annuity {} and interest {}", annuity, interest);
		BigDecimal principal = annuity.subtract(interest);
		logger.debug("Calculated principal: {}", principal);
		return principal;
	}
	
	/**
	 * Calculates the remaining outstanding principal from given initial outstanding principal and principal.
	 * @param initialOutstandingPrincipal the initial outstanding principal.
	 * @param principal the principal.
	 * @return the calculated remaining outstanding principal.
	 */
	public static final BigDecimal calculateRemainingOutstandingPrincipal(BigDecimal initialOutstandingPrincipal, BigDecimal principal) {
		logger.debug("Calculating remaining outstanding principal with initial outstanding principal {} and principal {}", initialOutstandingPrincipal, principal);
		BigDecimal remainingOutstandingPrincipal = initialOutstandingPrincipal.subtract(principal);
		logger.debug("Calculated remaining outstanding principal: {}", remainingOutstandingPrincipal);
		return remainingOutstandingPrincipal;
	}
	
	/**
	 * Calculates the borrower payment amount from given principal and interest rate.
	 * @param principal the principal amount.
	 * @param interest the interest rate.
	 * @return the calculated borrower payment amount.
	 */
	public static final BigDecimal calculateBorrowerPaymentAmount(BigDecimal principal, BigDecimal interest) {
		logger.debug("Calculating borrower payment amount with principal {} and interest {}", principal, interest);
		BigDecimal borrowerPaymentAmount = principal.add(interest);
		logger.debug("Calculated borrower payment amount: {}", borrowerPaymentAmount);
		return borrowerPaymentAmount;
	}
}
