package com.malaquf.services.plan_generator.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.malaquf.services.plan_generator.dto.GeneratePlanRequest;
import com.malaquf.services.plan_generator.dto.ResponseError;
import com.malaquf.services.plan_generator.error.ErrorCode;

@Component
/**
 * General request validator for avoiding NPEs.
 *
 */
public class EmptyRequestValidator implements GeneratePlanRequestValidator {

	@Override
	public final List<ResponseError> validate(GeneratePlanRequest request) {
		List<ResponseError> result = new ArrayList<>();
		if (request == null) {
			ResponseError responseError = ResponseError.builder()
			  .code(ErrorCode.MISSING_REQUEST.getValue())
			  .message("Missing request.")
			  .build();
			result.add(responseError);
		}
		return result;
	}

}
