package com.malaquf.services.plan_generator.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.malaquf.services.plan_generator.utils.Calculator;

class CalculatorTest {
	
	@Test
	void calculateAnnuityTest() {
		BigDecimal annuity = Calculator.calculateAnnuity(24, BigDecimal.valueOf(5000), BigDecimal.valueOf(5));
		assertEquals(BigDecimal.valueOf(219.36), annuity);
	}
	
	@Test
	void calculateInterestTest() {
		BigDecimal interest = Calculator.calculateInterest(BigDecimal.valueOf(5), BigDecimal.valueOf(5000));
		assertEquals(BigDecimal.valueOf(20.83), interest);
	}
	
	@Test
	void calculatePrincipalTest() {
		BigDecimal principal = Calculator.calculatePrincipal(BigDecimal.valueOf(219.36), BigDecimal.valueOf(20.83));
		assertEquals(BigDecimal.valueOf(198.53), principal);
	}
	
	@Test
	void calculateRemainingOutstandingPrincipalTest() {
		BigDecimal remainingOutstandingPrincipal = Calculator.calculateRemainingOutstandingPrincipal(BigDecimal.valueOf(5000), BigDecimal.valueOf(198.53));
		assertEquals(BigDecimal.valueOf(4801.47), remainingOutstandingPrincipal);
	}
	
	@Test
	void calculateBorrowerPaymentAmountTest() {
		BigDecimal borrowerPaymentAmount = Calculator.calculateBorrowerPaymentAmount(BigDecimal.valueOf(198.53), BigDecimal.valueOf(20.83));
		assertEquals(BigDecimal.valueOf(219.36), borrowerPaymentAmount);
	}
}
