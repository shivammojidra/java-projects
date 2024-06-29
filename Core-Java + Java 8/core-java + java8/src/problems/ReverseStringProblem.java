package problems;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class ReverseStringProblem {
	
	public static void reverseString(String stringToReverse) {
		UnaryOperator<String> uop = p-> new StringBuffer(p).reverse().toString();
		Consumer<String> stringConsumer = p1 -> System.out.println(new StringBuffer(p1).reverse().toString());
//		StringBuilder stringBuilder = new StringBuilder(stringToReverse);
//		stringBuilder.reverse();
		System.out.println(uop.apply(stringToReverse));//With Function/UnaryOperator
		stringConsumer.accept(stringToReverse);//With Consumer
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter String to reverse:");
		String string = scanner.nextLine();
		scanner.close();
		reverseString(string);
	}

}
