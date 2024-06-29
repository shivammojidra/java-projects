package problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ThreadOfProblems {

	public static void main(String[] args) throws InterruptedException {
		
		//Input for Lambdas & Streams problem
		String str = "";
		String reader ;
		
		try {
			File newFile = new File("./problem2input.txt");
			if (newFile.exists()) {
				BufferedReader br = new BufferedReader(new FileReader(newFile));				
				while ((reader=br.readLine())!=null) {
					str+=reader;
				}
				br.close();
				System.out.println("Content of File:");
				System.out.println(str);
			}else {
				System.out.println("File Doesn't Exist!!");
			}
		} catch (Exception e) {
			System.out.println("Hii I'm Exception "+e);
		}
		
		String str1[] = str.split(",");
		
		ArrayList<Integer> lst = new ArrayList<>();
		for(String s:str1){
			if(s!="") 
				lst.add(Integer.valueOf(s));
		}
		
		//Input for Date & Age Problem -- AgeCalculator
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter BirthDate (In format dd-mm-yyyy):");
		String birthString = scanner.nextLine();
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("d-M-yyyy");
		
		
		//Input For Reverse String Problem
		System.out.println("Enter String to reverse:");
		String string = scanner.nextLine();
		
		scanner.close();
		Runnable r1 = ()->{
			System.out.println(LambdasAndStreams.listToCommaSeparatedString(lst));
		};
		Runnable r2 = ()->{
			AgeCalculator.calculateAge(birthString, format);
		};
		Runnable r3 = ()->{
			ReverseStringProblem.reverseString(string);
		};
		
		Thread thread_of_problem1 = new Thread(r1);
		Thread thread_of_problem2 = new Thread(r2);
		Thread thread_of_problem3 = new Thread(r3);
		
		thread_of_problem1.start();
		thread_of_problem2.start();
		thread_of_problem3.start();
		

	}

}
