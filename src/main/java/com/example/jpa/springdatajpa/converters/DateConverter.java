package com.example.jpa.springdatajpa.converters;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;


import com.fasterxml.jackson.databind.util.StdConverter;

public class DateConverter extends StdConverter<Date, String>{

	@Override
	public String convert(Date value) {

		if(value!=null) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			return dateFormat.format(value);
		}
		return null;
	}

	
}
