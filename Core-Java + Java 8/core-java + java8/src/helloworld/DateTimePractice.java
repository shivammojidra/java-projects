package helloworld;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

//Hackerrank Code Implementation
//URL : https://www.hackerrank.com/challenges/java-date-and-time/forum

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
    	String str = "MAY";
    	LocalDate ld = LocalDate.of(year, month, day);
    	DayOfWeek dayOfWeek = ld.getDayOfWeek();
        return dayOfWeek.toString();
    }

}

public class DateTimePractice {

	public static void main(String[] args) throws IOException {
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("Enter Date (ex. dd mm yyy):");
//		int day = scanner.nextInt();
//		int month = scanner.nextInt();
//		int year = scanner.nextInt();
//		
//		System.out.println(Result.findDay(month, day, year));
		
//		DayOfWeek ldt = LocalDateTime.of(2023, 3, 12,0,0).getDayOfWeek();
//		System.out.println(ldt.toString());
//		System.out.println(ldt);
//		
//		System.out.println(LocalDate.now());
//		System.out.println(LocalTime.now());
//		
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
//		System.out.println(LocalDateTime.now().format(format));
		
		LocalDate birth = LocalDate.of(2002, Month.MARCH, 12);
		LocalDate today = LocalDate.now();
		
		Period p = Period.between(birth, today);
		System.out.printf("Years %d Months %d Days %d\n",p.getYears(),p.getMonths(),p.getDays());
		System.out.println(p.getYears()+" "+p.getMonths()+" "+p.getDays());
		
		ZoneId z = ZoneId.systemDefault();
		System.out.println(z);
		
		ZoneId la = ZoneId.of("America/Los_Angeles");
		System.out.println(la);
		
		ZonedDateTime laTime = ZonedDateTime.now(la);
		System.out.println("Current time in Los Angeles is : "+laTime.getHour()+":"+laTime.getMinute());
		
		//Pass Date as string & get LocalDate object 
		String str = "12-03-2002";
		DateTimeFormatter format = DateTimeFormatter.ofPattern("d-M-yyyy");
		LocalDate dt = LocalDate.parse(str, format);
		System.out.println("Day: "+dt.getDayOfMonth());
		System.out.println("Month: "+ dt.getMonthValue());
		System.out.println("Year: "+dt.getYear());
		System.out.println("Day of Week on that date: "+ dt.getDayOfWeek());
		
		
	}

}
