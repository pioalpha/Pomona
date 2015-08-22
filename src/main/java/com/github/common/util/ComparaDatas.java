package com.github.common.util;

import java.util.Calendar;
import java.util.Date;

public class ComparaDatas {
	
	
	public static long comparaApenasDatas(Date d1, Date d2) {
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c1.setTime(d1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);

		c2.setTime(d2);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 0);
		
		return c1.compareTo(c2);
	}
}
