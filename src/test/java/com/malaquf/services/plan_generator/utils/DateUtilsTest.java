package com.malaquf.services.plan_generator.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.malaquf.services.plan_generator.utils.DateUtils;

class DateUtilsTest {

	@Test
	void testIncrementMonthWithoutTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 0, 1, 1, 10, 30);
		Date date = calendar.getTime();
		
		Date newDate = DateUtils.incrementMonthWithoutTime(date);
		
		calendar.setTime(newDate);
		assertEquals(2018, calendar.get(Calendar.YEAR));
		assertEquals(1, calendar.get(Calendar.MONTH));
		assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
		assertEquals(1, calendar.get(Calendar.HOUR));
		assertEquals(0, calendar.get(Calendar.MINUTE));
		assertEquals(0, calendar.get(Calendar.SECOND));
	}
	
	@Test
	void testRemoveTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 0, 1, 1, 10, 30);
		Date date = calendar.getTime();
		
		Date newDate = DateUtils.removeTime(date);
		
		calendar.setTime(newDate);
		assertEquals(2018, calendar.get(Calendar.YEAR));
		assertEquals(0, calendar.get(Calendar.MONTH));
		assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
		assertEquals(1, calendar.get(Calendar.HOUR));
		assertEquals(0, calendar.get(Calendar.MINUTE));
		assertEquals(0, calendar.get(Calendar.SECOND));
	}

}
