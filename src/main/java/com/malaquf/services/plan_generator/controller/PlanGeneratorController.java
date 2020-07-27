package com.malaquf.services.plan_generator.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.malaquf.services.plan_generator.dto.BorrowerPayment;
import com.malaquf.services.plan_generator.dto.GeneratePlanRequest;
import com.malaquf.services.plan_generator.dto.GeneratePlanResponse;
import com.malaquf.services.plan_generator.dto.ResponseError;
import com.malaquf.services.plan_generator.service.PlanGeneratorService;
import com.malaquf.services.plan_generator.validator.GeneratePlanRequestValidator;

@RestController
public class PlanGeneratorController {
	
	private Logger logger = LoggerFactory.getLogger(PlanGeneratorController.class);
	private List<GeneratePlanRequestValidator> requestValidators;
    private final PlanGeneratorService planGeneratorService;

    public PlanGeneratorController(PlanGeneratorService planGeneratorService, List<GeneratePlanRequestValidator> requestValidators) {
        this.planGeneratorService = planGeneratorService;
        this.requestValidators = requestValidators;
    }

	@PostMapping(value = "/generate-plan", produces = "application/json")
	public final ResponseEntity<GeneratePlanResponse> generatePlan(@RequestBody GeneratePlanRequest request) {
		logger.info("Request: {}", request);
		
		ResponseError[] errors = validateRequest(request);
		if (errors.length > 0) {
			logger.error("Invalid request");
			GeneratePlanResponse response = GeneratePlanResponse.builder()
					.errors(errors)
					.build();
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		List<BorrowerPayment> borrowerPayments = this.planGeneratorService.generateBorrowerPayments(
				request.getLoanAmount(), request.getNominalRate(), 
				request.getDuration(), request.getStartDate());
		
		GeneratePlanResponse response = GeneratePlanResponse.builder()
		  .borrowerPayments(borrowerPayments)
		  .build();
		logger.info("Response: {}", response);
		return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	protected final ResponseError[] validateRequest(GeneratePlanRequest request) {
		if (this.requestValidators == null) {
			return new ResponseError[0];
		}
		
		List<ResponseError> errorList = new ArrayList<>();
		
		for (GeneratePlanRequestValidator validator : requestValidators) {
			errorList.addAll(validator.validate(request));
		}
		
		ResponseError[] errors = new ResponseError[errorList.size()];
		errorList.toArray(errors);
		return errors;
	}
}
