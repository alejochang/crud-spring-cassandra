/*
 * CassandraUtils.java
 *
 * 1.0 (10/09/2011)
 *
 * Alejandro Chang (alejochang@gmail.com) 
 */

package chang.alejandro.crud.example.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0 (10/09/2011)
 * Performs common functions across the application.
 * @author Alejandro Chang (alejochang@gmail.com)
 *
 */
public class CassandraUtils {
	
	public static DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd") ;
	
	/**
	 * Gets a formatted string by the given date
	 * The format used to return the string is defined with <code>FORMATTER</code> 
	 */
	public static String getFormattedDateString(Date date) {
		String dateStringFormatted = null; 
		if(date != null) {
			dateStringFormatted = FORMATTER.format(date);
		}
		return dateStringFormatted;
	}
	
	/**
	 * Parses the given string to obtain a date
	 * The expected format is defined with <code>FORMATTER</code> 
	 */
	public static Date parseDate(String formattedString) {
		Date date = null;
		if(formattedString != null && formattedString.length() > 0) {
			try {
				date = FORMATTER.parse(formattedString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return date;
	}
	
	public static Boolean getValidatedBoolean(String value) {
		Boolean result = false;
		if(value == null || value.toUpperCase().equals("OFF")) {
			value = Boolean.FALSE.toString();
		}else if (value.toUpperCase().equals("ON")) {
			value = Boolean.TRUE.toString();
		}
		try {
			Boolean.valueOf(value);
		}catch (Exception e) {
			result = false;
		}
		return result;
	}

}
