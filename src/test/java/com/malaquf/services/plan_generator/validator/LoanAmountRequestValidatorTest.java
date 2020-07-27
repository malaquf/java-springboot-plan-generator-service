package com.malaquf.services.plan_generator.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.malaquf.services.plan_generator.dto.GeneratePlanRequest;
import com.malaquf.services.plan_generator.dto.ResponseError;
import com.malaquf.services.plan_generator.error.ErrorCode;
import com.malaquf.services.plan_generator.validator.LoanAmountRequestValidator;

public class LoanAmountRequestValidatorTest {

private LoanAmountRequestValidator testInstance;
	
	@BeforeEach
	public void setUp() {
		this.testInstance = new LoanAmountRequestValidator();
	}
	
	@Test
	void testValidateNullRequest() {
		List<ResponseError> actual = this.testInstance.validate(null);
		assertTrue(actual.isEmpty());
	}
	
	@Test
	void testValidateMissingLoanAmount() {
		List<ResponseError> expected = Arrays.asList(new ResponseError(ErrorCode.MISSING_LOAN_AMOUNT, "Missing loan amount."));
		List<ResponseError> actual = this.testInstance.validate(GeneratePlanRequest.builder().build());
		assertEquals(expected, actual);
	}
	
	@Test
	void testValidateNegatieLoanAmount() {
		List<ResponseError> expected = Arrays.asList(new ResponseError(ErrorCode.INVALID_LOAN_AMOUNT, "Invalid loan amount."));
		GeneratePlanRequest request = GeneratePlanRequest.builder().loanAmount(BigDecimal.valueOf(-10000)).build();
		List<ResponseError> actual = this.testInstance.validate(request);
		assertEquals(expected, actual);
	}
}
