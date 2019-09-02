package com.hanwha.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	
	public static Date transDate(String sdate) {
		
		Date sql_date = null;
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		//이건 실제로 뽑아보고 양식을 결정한다.
		try {
			java.util.Date d = sd.parse(sdate);
			sql_date = new Date(d.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sql_date;
	}
	
}
