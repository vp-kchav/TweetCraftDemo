package com.intuit.demo.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 
 * @author kchav
 *
 */
public class DateTimeUtils {
	
	/**
	 * This method is to generateDate base on the string and format provided
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date getDateFromString(String date, String format) {
		try {
			DateFormat dateFormat = new SimpleDateFormat(format,Locale.US);
			return dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
