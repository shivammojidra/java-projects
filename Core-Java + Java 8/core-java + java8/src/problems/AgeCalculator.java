package problems;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AgeCalculator {
	
	public static void calculateAge(String birthString,DateTimeFormatter format) {
		LocalDate birthdayDate = LocalDate.parse(birthString, format);
		LocalDate todayDate = LocalDate.now();
		
		Period diff = Period.between(birthdayDate, todayDate);
		int years = diff.getYears();
		int months = diff.getMonths();
		int days = diff.getDays();
		int age = years*365+months*30+days;//Assuming month of 30 days & ignoring 1 day of leap year
		
		System.out.println("---------------------------------");
		System.out.println("Your Age is:");
		System.out.println("Years: "+years+" Months: "+months+" Days: "+days);
		
		System.out.println("Your Age in Days is: "+ age+" Days");
		System.out.println("---------------------------------");	
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter BirthDate (In format dd-mm-yyyy):");
		String birthString = scanner.nextLine();
		scanner.close();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("d-M-yyyy");
		
		calculateAge(birthString, format);
		
	}

}
