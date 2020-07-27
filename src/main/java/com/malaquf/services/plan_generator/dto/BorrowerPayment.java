package com.malaquf.services.plan_generator.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.malaquf.services.plan_generator.json.MoneySerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Borrower payment.
 */
@Getter @Setter @ToString @EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BorrowerPayment {
	
	@JsonSerialize(using = MoneySerializer.class)
	private BigDecimal borrowerPaymentAmount;
	@JsonSerialize(using = MoneySerializer.class)
	private BigDecimal initialOutstandingPrincipal;
	@JsonSerialize(using = MoneySerializer.class)
	private BigDecimal remainingOutstandingPrincipal;
	@JsonSerialize(using = MoneySerializer.class)
	private BigDecimal interest;
	@JsonSerialize(using = MoneySerializer.class)
	private BigDecimal principal;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone="GMT")
	private Date date;

}
