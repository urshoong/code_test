package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class dateformattest {
	public static void main(String[] args) {
		System.out.println(nowSysDate(0, "yyMM"));
	}
	
	public static String nowSysDate(int days, String format)
	{
		Calendar cal   = Calendar.getInstance();
		cal.add(Calendar.DATE, days);     
		java.util.Date currentTime = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String timestr = formatter.format(currentTime);

		return timestr;
	}
}
