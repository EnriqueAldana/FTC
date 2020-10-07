/**
 * 
 */
package com.cucoex.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



/**
 * @author enrique
 *
 */
public final class Utileria {

	/**
	 * 
	 */
	public Utileria() {
		
	}
	
	
	public static Calendar sumarDias(Calendar fecha, int dias) {
		fecha.add(Calendar.DAY_OF_MONTH, dias); 
		return fecha;
		
	}
	
	public static Calendar sumarMeses(Calendar fecha, int meses) {

		fecha.add(Calendar.MONTH, meses); 
		return fecha;

		
	}

	public static Calendar sumarAnios(Calendar fecha, int anios) {
	
		fecha.add(Calendar.YEAR, anios); 
		return fecha;
	
}
	
	public static Date convertStringToDate(String format, String string) {
		
		Date ret=null;
		try {
			ret= new SimpleDateFormat(format).parse(string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	public static LocalDate convertToLocalDate(Date dateToConvert) {
	    return LocalDate.ofInstant(
	      dateToConvert.toInstant(), ZoneId.systemDefault());
	}
	 
	public static LocalDateTime convertToLocalDateTime(Date dateToConvert) {
	    return LocalDateTime.ofInstant(
	      dateToConvert.toInstant(), ZoneId.systemDefault());
	}
	
	public static Calendar dateToCalendar(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;

	}

	//Convert Calendar to Date
	public static Date calendarToDate(Calendar calendar) {
		return calendar.getTime();
	}
	
	
	public static LocalDate convertDataToLocalDate(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	
	public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}
	
	public static Date convertToDateViaSqlDate(LocalDate dateToConvert) {
	    return java.sql.Date.valueOf(dateToConvert);
	}
	
	public static Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
	    return java.sql.Timestamp.valueOf(dateToConvert);
	}
	
	public static <T> Set<T> convertListToSet(List<T> list) 
    { 
        // create an empty set 
        Set<T> set = new HashSet<>(); 
  
        // Add each element of list into the set 
        for (T t : list) 
            set.add(t); 
  
        // return the set 
        return set; 
    } 
	

}
