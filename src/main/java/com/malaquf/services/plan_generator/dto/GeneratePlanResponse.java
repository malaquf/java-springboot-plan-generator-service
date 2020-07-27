package com.malaquf.services.plan_generator.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Borrower plan consists of a list of borrower payments.
 *
 */
@JsonInclude(Include.NON_NULL)
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
public class GeneratePlanResponse {

	/**
	 * List of borrower payment.
	 */
	private List<BorrowerPayment> borrowerPayments;
	
	private ResponseError[] errors;

	public GeneratePlanResponse(ResponseError[] errors) {
		this.errors = errors;
	}
	
	public GeneratePlanResponse(List<BorrowerPayment> borrowerPayments) {
		this.borrowerPayments = borrowerPayments;
	}
}
