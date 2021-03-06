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
import com.malaquf.services.plan_generator.validator.NominalRateRequestValidator;

class NominalRateRequestValidatorTest {

	private NominalRateRequestValidator testInstance;
	
	@BeforeEach
	public void setUp() {
		this.testInstance = new NominalRateRequestValidator();
	}
	
	@Test
	void testValidateNullRequest() {
		List<ResponseError> actual = this.testInstance.validate(null);
		assertTrue(actual.isEmpty());
	}
	
	@Test
	void testValidateMissingNominalRate() {
		List<ResponseError> expected = Arrays.asList(new ResponseError(ErrorCode.MISSING_NOMINAL_RATE, "Missing nominal rate."));
		List<ResponseError> actual = this.testInstance.validate(GeneratePlanRequest.builder().build());
		assertEquals(expected, actual);
	}
	
	@Test
	void testValidateNegativeNominalRate() {
		List<ResponseError> expected = Arrays.asList(new ResponseError(ErrorCode.INVALID_NOMINAL_RATE, "Invalid negative nominal rate."));
		GeneratePlanRequest request = GeneratePlanRequest.builder().nominalRate(BigDecimal.valueOf(-5)).build();
		List<ResponseError> actual = this.testInstance.validate(request);
		assertEquals(expected, actual);
	}
}
