package com.malaquf.services.plan_generator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.malaquf.services.plan_generator.dto.BorrowerPayment;
import com.malaquf.services.plan_generator.dto.GeneratePlanResponse;
import com.malaquf.services.plan_generator.service.PlanGeneratorService;
import com.malaquf.services.plan_generator.utils.JsonUtils;

@SpringBootTest
class PlanGeneratorServiceTest {

	@Autowired
	PlanGeneratorService planGeneratorService;
	
	@DisplayName("Test borrower payments generation with example data.")
    @Test
    void testGenerateBorrowerPayments() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 0, 1, 0, 0, 0);
		Date startDate = calendar.getTime();
		Integer duration = 24;
		
		List<BorrowerPayment> borrowerPayments = this.planGeneratorService.generateBorrowerPayments(
				BigDecimal.valueOf(5000), BigDecimal.valueOf(5), duration, startDate);
        
		GeneratePlanResponse expectedResponse = JsonUtils.readJson("responses/expectedPlan1.json", GeneratePlanResponse.class);
		assertEquals(expectedResponse.getBorrowerPayments(), borrowerPayments);
    }
	
}
