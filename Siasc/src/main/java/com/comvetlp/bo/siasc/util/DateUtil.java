package com.comvetlp.bo.siasc.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static final String FORMAT_DATE="dd/MM/yyyy";
	public static final String FORMAT_DATE_TIME="dd/MM/yyyy HH:mm:ss";
	public static final String FORMAT_KEY="yyyyMMDDHHmmssSSS";
	public static final String FORMAT_MESSAGE="Sin fecha registrada";

	public static String generateKey() {
		SimpleDateFormat sdf=new SimpleDateFormat(FORMAT_KEY);
		return sdf.format(new Date());
	}

	public static String toString(String format, Date fecha){
		try {
			SimpleDateFormat sdf=new SimpleDateFormat(format);
			return sdf.format(fecha);
		}
		catch (Exception e){
			return FORMAT_MESSAGE;
		}
	}

	public static Date toDate(String format, String fecha){
		try {
			SimpleDateFormat sdf=new SimpleDateFormat(format);
			return sdf.parse(fecha);
		}
		catch (Exception e){
			return null;
		}
	}

	public static Date cambiarPrimeraHora(Date fecha){
		if(fecha==null){
			return null;
		}
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND,0);
		return calendar.getTime();
	}

	public static Date cambiarUltimaHora(Date fecha){
		if(fecha==null){
			return null;
		}
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.set(Calendar.HOUR_OF_DAY,calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE,calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND,calendar.getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND,calendar.getActualMaximum(Calendar.MILLISECOND));
		return calendar.getTime();
	}

	public static Date fechaMinima(){

		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH,01);
		calendar.set(Calendar.MONDAY,01);
		calendar.set(Calendar.YEAR,1910);
		return calendar.getTime();
	}
}
