package com.malaquf.services.plan_generator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.malaquf.services.plan_generator.controller.PlanGeneratorController;
import com.malaquf.services.plan_generator.dto.GeneratePlanRequest;
import com.malaquf.services.plan_generator.dto.GeneratePlanResponse;
import com.malaquf.services.plan_generator.utils.JsonUtils;

@SpringBootTest
class PlanGeneratorControllerIT {
	
	@Autowired
	PlanGeneratorController planGeneratorController;
	
	@DisplayName("Test null request.")
    @Test
    void testGeneratePlanNullRequest() throws Exception {
		ResponseEntity<GeneratePlanResponse> response = this.planGeneratorController.generatePlan(null);
		assertNotNull(response);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		GeneratePlanResponse actualResponse = response.getBody();
		GeneratePlanResponse expectedResponse = JsonUtils.readJson("responses/missingRequest.json", GeneratePlanResponse.class);
		assertEquals(expectedResponse, actualResponse);
	}

	@DisplayName("Test all missing args.")
    @Test
    void testGeneratePlanMissingParams() throws Exception {
		GeneratePlanRequest request = GeneratePlanRequest.builder().build();
		ResponseEntity<GeneratePlanResponse> response = this.planGeneratorController.generatePlan(request);
		assertNotNull(response);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		GeneratePlanResponse actualResponse = response.getBody();
		GeneratePlanResponse expectedResponse = JsonUtils.readJson("responses/missingParams.json", GeneratePlanResponse.class);
		assertEquals(expectedResponse, actualResponse);
	}
	
	@DisplayName("Test success with example data.")
    @Test
    void testGeneratePlanSuccess() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 0, 1, 0, 0, 0);
		Date startDate = calendar.getTime();
		GeneratePlanRequest request = new GeneratePlanRequest(BigDecimal.valueOf(5000), BigDecimal.valueOf(5), 24, startDate);
		ResponseEntity<GeneratePlanResponse> response = this.planGeneratorController.generatePlan(request);
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		GeneratePlanResponse actualResponse = response.getBody();
		GeneratePlanResponse expectedResponse = JsonUtils.readJson("responses/expectedPlan1.json", GeneratePlanResponse.class);
		assertEquals(expectedResponse, actualResponse);
	}
}
