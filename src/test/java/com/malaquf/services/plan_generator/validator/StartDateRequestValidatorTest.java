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
import com.malaquf.services.plan_generator.validator.StartDateRequestValidator;

class StartDateRequestValidatorTest {

	private StartDateRequestValidator testInstance;
	
	@BeforeEach
	public void setUp() {
		this.testInstance = new StartDateRequestValidator();
	}
	
	@Test
	void testValidateNullRequest() {
		List<ResponseError> actual = this.testInstance.validate(null);
		assertTrue(actual.isEmpty());
	}
	
	@Test
	void testValidateMissingStartDate() {
		List<ResponseError> expected = Arrays.asList(new ResponseError(ErrorCode.MISSING_START_DATE, "Missing start date."));
		List<ResponseError> actual = this.testInstance.validate(GeneratePlanRequest.builder().build());
		assertEquals(expected, actual);
	}
	
}
