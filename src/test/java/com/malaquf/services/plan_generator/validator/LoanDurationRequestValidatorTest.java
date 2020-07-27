package com.malaquf.services.plan_generator.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.malaquf.services.plan_generator.dto.GeneratePlanRequest;
import com.malaquf.services.plan_generator.dto.ResponseError;
import com.malaquf.services.plan_generator.error.ErrorCode;
import com.malaquf.services.plan_generator.validator.LoanDurationRequestValidator;

class LoanDurationRequestValidatorTest {

	private LoanDurationRequestValidator testInstance;
	
	@BeforeEach
	public void setUp() {
		this.testInstance = new LoanDurationRequestValidator();
	}
	
	@Test
	void testValidateNullRequest() {
		List<ResponseError> actual = this.testInstance.validate(null);
		assertTrue(actual.isEmpty());
	}
	
	@Test
	void testValidateMissingLoanDuration() {
		List<ResponseError> expected = Arrays.asList(new ResponseError(ErrorCode.MISSING_LOAN_DURATION, "Missing loan duration."));
		List<ResponseError> actual = this.testInstance.validate(GeneratePlanRequest.builder().build());
		assertEquals(expected, actual);
	}
	
	@Test
	void testValidateNegatieLoanDuration() {
		List<ResponseError> expected = Arrays.asList(new ResponseError(ErrorCode.INVALID_LOAN_DURATION, "Invalid loan duration: -24"));
		GeneratePlanRequest request = GeneratePlanRequest.builder().duration(-24).build();
		List<ResponseError> actual = this.testInstance.validate(request);
		assertEquals(expected, actual);
	}
}
