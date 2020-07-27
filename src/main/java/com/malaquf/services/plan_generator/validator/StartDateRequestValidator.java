package com.malaquf.services.plan_generator.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.malaquf.services.plan_generator.dto.GeneratePlanRequest;
import com.malaquf.services.plan_generator.dto.ResponseError;
import com.malaquf.services.plan_generator.error.ErrorCode;

@Component
/**
 * The start date validator.
 */
public class StartDateRequestValidator implements GeneratePlanRequestValidator {

	@Override
	public final List<ResponseError> validate(GeneratePlanRequest request) {
		List<ResponseError> result = new ArrayList<>();
		if (request == null) {
			return result;
		}
		
		if (request.getStartDate() == null) {
			ResponseError responseError = ResponseError.builder()
					  .code(ErrorCode.MISSING_START_DATE.getValue())
					  .message("Missing start date.")
					  .build();
			result.add(responseError);
		}
		
		return result;
	}

}
