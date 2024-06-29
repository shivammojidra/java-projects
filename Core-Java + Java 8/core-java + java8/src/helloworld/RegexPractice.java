package helloworld;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexPractice {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		
		System.out.println(Pattern.matches("[0-2]", str));
	}

}
