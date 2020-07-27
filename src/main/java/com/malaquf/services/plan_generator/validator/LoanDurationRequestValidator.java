package com.malaquf.services.plan_generator.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.malaquf.services.plan_generator.dto.GeneratePlanRequest;
import com.malaquf.services.plan_generator.dto.ResponseError;
import com.malaquf.services.plan_generator.error.ErrorCode;

@Component
/**
 * The loan duration validator.
 */
public class LoanDurationRequestValidator implements GeneratePlanRequestValidator {

	@Override
	public final List<ResponseError> validate(GeneratePlanRequest request) {
		List<ResponseError> result = new ArrayList<>();
		if (request == null) {
			return result;
		}
		
		if (request.getDuration() == null) {
			ResponseError responseError = ResponseError.builder()
					  .code(ErrorCode.MISSING_LOAN_DURATION.getValue())
					  .message("Missing loan duration.")
					  .build();
			result.add(responseError);
		}
		else if (request.getDuration() <= 0) {
			ResponseError responseError = ResponseError.builder()
					  .code(ErrorCode.INVALID_LOAN_DURATION.getValue())
					  .message("Invalid loan duration: " + request.getDuration())
					  .build();
			result.add(responseError);
		}
		
		return result;
	}

	
}
