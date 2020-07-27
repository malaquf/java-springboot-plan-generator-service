package com.malaquf.services.plan_generator.validator;

import java.util.List;

import com.malaquf.services.plan_generator.dto.GeneratePlanRequest;
import com.malaquf.services.plan_generator.dto.ResponseError;

/**
 * Validator for generate plan requests.
 */
public interface GeneratePlanRequestValidator {

	/**
	 * Validates a {@link GeneratePlanRequest};
	 * @param request the request to be validated.
	 * @return list of response errors, if one or more error occurs during validation. Never null. See {@link ResponseError}.
	 */
	public List<ResponseError> validate(GeneratePlanRequest request);
}
