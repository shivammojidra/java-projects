package helloworld;

import java.util.Calendar;
import java.util.TimeZone;

public class CalenderPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getCalendarType());
		System.out.println(calendar.getTimeZone());
		System.out.println(calendar.getTimeZone().getID());

		Calendar calendar1 = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
		System.out.println(calendar1.getTimeZone());
		System.out.println(calendar1.getTimeZone().getID());
		System.out.println(calendar1.getTime());
		System.out.println(calendar1.get(Calendar.DAY_OF_WEEK));
//		SimpleDateFormat c
	}

}
