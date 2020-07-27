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
import com.malaquf.services.plan_generator.validator.EmptyRequestValidator;

class EmptyRequestValidatorTest {

	private EmptyRequestValidator testInstance;
	
	@BeforeEach
	public void setUp() {
		this.testInstance = new EmptyRequestValidator();
	}
	
	@Test
	void testValidateNullRequest() {
		List<ResponseError> expected = Arrays.asList(new ResponseError(ErrorCode.MISSING_REQUEST, "Missing request."));
		List<ResponseError> actual = this.testInstance.validate(null);
		assertEquals(expected, actual);
	}
	
	@Test
	void testValidateRequestSuccess() {
		List<ResponseError> actual = this.testInstance.validate(GeneratePlanRequest.builder().build());
		assertTrue(actual.isEmpty());
	}
}
