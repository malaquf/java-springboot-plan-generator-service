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
 * The loan amount validator.
 */
public class LoanAmountRequestValidator implements GeneratePlanRequestValidator {

	@Override
	public final List<ResponseError> validate(GeneratePlanRequest request) {
		List<ResponseError> result = new ArrayList<>();
		if (request == null) {
			return result;
		}
		
		if (request.getLoanAmount() == null) {
			ResponseError responseError = ResponseError.builder()
					  .code(ErrorCode.MISSING_LOAN_AMOUNT.getValue())
					  .message("Missing loan amount.")
					  .build();
			result.add(responseError);
		}
		else if (request.getLoanAmount().compareTo(BigDecimal.ZERO) <= 0) {
			ResponseError responseError = ResponseError.builder()
					  .code(ErrorCode.INVALID_LOAN_AMOUNT.getValue())
					  .message("Invalid loan amount.")
					  .build();
			result.add(responseError);
		}
		
		return result;
	}
}
