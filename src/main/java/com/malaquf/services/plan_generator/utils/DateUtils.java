package com.malaquf.services.plan_generator.utils;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

/**
 * Utility class for manipulating Date objects.
 *
 */
public class DateUtils {

	private DateUtils() {
		// hidden
	}
	
	/**
	 * Increments date by one month with zeroed time values.
	 * @param date date to be incremented by one month.
	 * @return date incremented by one month with zeroed time values.
	 */
	public static final Date incrementMonthWithoutTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		LocalDate sourceDate = LocalDate.of(
				cal.get(Calendar.YEAR), 
				cal.get(Calendar.MONTH) + 1, 
				cal.get(Calendar.DAY_OF_MONTH));
		sourceDate = sourceDate.plusMonths(1);
		return Date.from(sourceDate.atStartOfDay().toInstant(ZoneOffset.UTC));
	}
	
	
	/**
	 * Removes time data from given date.
	 * @param date date to remove time data from.
	 * @return date with zeroed time data.
	 */
	public static final Date removeTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		LocalDate sourceDate = LocalDate.of(
				cal.get(Calendar.YEAR), 
				cal.get(Calendar.MONTH) + 1, 
				cal.get(Calendar.DAY_OF_MONTH));
		return Date.from(sourceDate.atStartOfDay().toInstant(ZoneOffset.UTC));
	}
	
}
