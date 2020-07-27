package com.malaquf.services.plan_generator.validator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.malaquf.services.plan_generator.dto.GeneratePlanRequest;
import com.malaquf.services.plan_generator.dto.ResponseError;
import com.malaquf.services.plan_generator.error.ErrorCode;

@Component
/**
 * The nominal rate validator.
 */
public class NominalRateRequestValidator implements GeneratePlanRequestValidator {

	@Override
	public final List<ResponseError> validate(GeneratePlanRequest request) {
		List<ResponseError> result = new ArrayList<>();
		if (request == null) {
			return result;
		}
		
		if (request.getNominalRate() == null) {
			ResponseError responseError = ResponseError.builder()
					  .code(ErrorCode.MISSING_NOMINAL_RATE.getValue())
					  .message("Missing nominal rate.")
					  .build();
			result.add(responseError);
		}
		else if (request.getNominalRate().compareTo(BigDecimal.ZERO) < 0) {
			ResponseError responseError = ResponseError.builder()
					  .code(ErrorCode.INVALID_NOMINAL_RATE.getValue())
					  .message("Invalid negative nominal rate.")
					  .build();
			result.add(responseError);
		}
		
		return result;
	}
	

}
