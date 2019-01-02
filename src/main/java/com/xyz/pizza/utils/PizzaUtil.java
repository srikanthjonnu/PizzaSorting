package com.xyz.pizza.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class PizzaUtil {
	public static final String DATE_FORMAT="dd/MM/yyyy HH:mm:ss";
	
	public static String convertEpochToUTC(Long epochDate) {
		final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		String formattedDate = null;
		if (epochDate != null) {
			formattedDate = sdf.format(new Date(epochDate));
		}
		return formattedDate;
	}
}
