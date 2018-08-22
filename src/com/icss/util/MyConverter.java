package com.icss.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
public class MyConverter implements Converter<String, Timestamp> {

	@Override
	public Timestamp convert(String arg0) {
		// TODO Auto-generated method stub
		Timestamp tp=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt=sdf.parse(arg0);
			tp=new Timestamp(dt.getTime());			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return tp;
	}

}
