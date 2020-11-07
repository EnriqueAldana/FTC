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

import org.slf4j.LoggerFactory;

import com.cucoex.controller.CausalController;



/**
 * @author enrique
 *
 */
public final class Utileria {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(Utileria.class);

	/**
	 * 
	 */
	public Utileria() {
		
	}
	
	
	public static Calendar sumarDias(Calendar fecha, int dias) {
		fecha.add(Calendar.DAY_OF_MONTH, dias); 
		return fecha;
		
	}
	
	public static LocalDate sumarDias(LocalDate fecha, long dias) {
		return fecha.plusDays(dias); 	
	}
	public static Calendar sumarMeses(Calendar fecha, int meses) {

		fecha.add(Calendar.MONTH, meses); 
		return fecha;

		
	}

	public static Calendar sumarAnios(Calendar fecha, int anios) {
	
		fecha.add(Calendar.YEAR, anios); 
		return fecha;
	
}
	
	/*
	 * 
	 * he method returns 0 if the time represented by the argument is equal to the time represented 
	 * by this Calendar object; or a value less than 0 if the time of this Calendar is before the time represented 
	 * by the argument; or a value greater than 0 if the time of this Calendar is after the time represented.
	 * 
	 * Resultados
	 * fechaBase = fechaComparando ---> 0
	 * fechaBase < fechaComparando ---> -1
	 * fechaBase > fechaComparando ---> 1
	 * 
	 */
	public static int calendarcompareTo(Calendar fechaBase, Calendar fechaComparando) {

		int ret=0;
		log.info("fecha base donde el mes va de 0 a 11: " + fechaBase.toString());
		log.info("fecha comparando donde el mes va de 0 a 11: " + fechaComparando.toString());
		
		ret = fechaBase.compareTo(fechaComparando);
		log.info("Resultado comparacion" + ret);
		return ret;

	}
	
	public static int localDateCompareto(LocalDate fechaBase, LocalDate fechaComparando) {
		int ret=0;
		
		/*
		 * LocalDate nineApr = LocalDate.parse("2019-04-09");
		 * 
		 * LocalDate fourApr = LocalDate.parse("2019-04-04");
		 * 
		 * boolean isBefore = nineApr.isBefore(fourApr);
		 * System.out.println("nineApr is before fourApr :: " + isBefore);
		 * 
		 * boolean isAfter = nineApr.isAfter(fourApr);
		 * System.out.println("nineApr is after fourApr :: " + isAfter);
		 * 
		 * nineApr is before fourApr :: false nineApr is after fourApr :: true nineApr
		 * is equal to 04-09 :: true
		 */
        
        boolean isEqual = fechaBase.isEqual(fechaComparando);
        if(isEqual) {
        	ret=0;
        }else if(fechaBase.isBefore(fechaComparando)) {
        	ret= -1;
        	
        }else {
        	ret=1;
        }
        	
        
        return ret;
        
		
	}
	
	public static Date convertStringToDate(String format, String fecha) {
		
		
		
		Date ret=null;
		try {
			ret= new SimpleDateFormat(format).parse(fecha);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return ret;
	}
	
	public static Calendar convertStringToCalendar(String format , String fecha) {
		

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			cal.setTime(sdf.parse(fecha));
			cal.add(Calendar.HOUR, 23);   // Agregar 23 hras para que el dia este completo y las comparaciones sean correctas
			cal.add(Calendar.MINUTE, 59);
			cal.add(Calendar.MILLISECOND, 59000);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println(cal.getTime().toString());
		
		return cal;
	}
		public static String convertCalendarToString_dd_mm_yyyy(Calendar cal) {
		
			String ret=null;
		// El parametro de numero de mes es desde 0 a 11 por lo que hay quue sumar UNO.
			
		ret = cal.get(Calendar.DAY_OF_MONTH)+ "-" + (cal.get(Calendar.MONTH) + 1 ) + "-" + cal.get(Calendar.YEAR);
		log.info("Fecha String de Utilerias " + ret);
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
	
	public static LocalDate createToLocalDate(int anio , int mes , int dia) {
	    
		return LocalDate.of(anio, mes, dia);
	}
	
	public static LocalDate createToLocalDateFromString_yyyy_MM_dd(String fecha) {
		
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    // Aqui asegurar que el parametro venga en el formato correcto.
		
		String[] parts = fecha.split("-");
		String part1 = parts[0]; // 23
		String part2 = parts[1]; // 11
		String part3 = parts[2]; // 2020
		String dateStd= new String();
		if(!((part1.length() > 0 ) && (part1.length()==4))){
			dateStd= part3 + "-" + part2 +"-" +part1;
		}else {
			dateStd=fecha;
		}
		return LocalDate.parse(dateStd);
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
	
	public static Calendar getCalendarToday() {
		return Calendar.getInstance();

	}
	
	public static LocalDate LocalDateTodayDate() {
		
		return convertDataToLocalDate(new Date());

	}
	public static Date getCalendarTodayDate() {
		
		
		return Calendar.getInstance().getTime();
	}

}
