package com.Cyanurzz.SupremeOtter.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class FormatDate {
	
	private static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	public static Date toFormatDate(String date) {
		String tempDate = date;
		Date finalDate = null;
		try {
			finalDate = dateFormat.parse(tempDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return finalDate;
	}
	
}
