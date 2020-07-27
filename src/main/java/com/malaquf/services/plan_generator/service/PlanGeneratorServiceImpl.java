package com.malaquf.services.plan_generator.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.malaquf.services.plan_generator.dto.BorrowerPayment;
import com.malaquf.services.plan_generator.utils.Calculator;
import com.malaquf.services.plan_generator.utils.DateUtils;

/**
 * Default implementation for {@link PlanGeneratorService}.
 */
@Service
public class PlanGeneratorServiceImpl implements PlanGeneratorService {
	
	@Override
	public final List<BorrowerPayment> generateBorrowerPayments(
			final BigDecimal loanAmount, final BigDecimal nominalRate,
			final Integer duration, final Date startDate) {
		List<BorrowerPayment> result = new ArrayList<>(duration);
		if (loanAmount == null || nominalRate == null || duration == null || startDate == null) {
			return result;
		}

		BigDecimal annuity = Calculator.calculateAnnuity(duration, loanAmount, nominalRate);
		
		Date disbursementDate = DateUtils.removeTime(startDate);
		BigDecimal initialOutstandingPrincipal = loanAmount.setScale(2);
		
		for (int i = 0; i < duration; i++) {
			BorrowerPayment borrowerPayment = createBorrowerPayment(annuity, initialOutstandingPrincipal, 
					nominalRate, disbursementDate);
			result.add(borrowerPayment);
			disbursementDate = DateUtils.incrementMonthWithoutTime(disbursementDate);
			initialOutstandingPrincipal = borrowerPayment.getRemainingOutstandingPrincipal();
		}
		
		return result;
	}
	
	protected final BorrowerPayment createBorrowerPayment(
			BigDecimal annuity, BigDecimal initialOutstandingPrincipal, 
			BigDecimal nominalRate, Date disbursementDate) {
		BigDecimal interest = Calculator.calculateInterest(nominalRate, initialOutstandingPrincipal);
		BigDecimal principal = Calculator.calculatePrincipal(annuity, interest);
		if (principal.compareTo(initialOutstandingPrincipal) > 0) {
			principal = initialOutstandingPrincipal;
		}
		BigDecimal remainingOutstandingPrincipal = Calculator.calculateRemainingOutstandingPrincipal(initialOutstandingPrincipal, principal);
		BigDecimal borrowerPaymentAmount = Calculator.calculateBorrowerPaymentAmount(principal, interest);
		
		return BorrowerPayment.builder()
		  .borrowerPaymentAmount(borrowerPaymentAmount)
		  .initialOutstandingPrincipal(initialOutstandingPrincipal)
		  .remainingOutstandingPrincipal(remainingOutstandingPrincipal)
		  .interest(interest)
		  .principal(principal)
		  .date(disbursementDate)
		  .build();
	}

}
