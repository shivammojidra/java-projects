package helloworld;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class StreanPractice {

	public static void main(String[] args) {
		
		List<Integer> lst = Arrays.asList(1,2,4,5,3);
		
		int sum = lst.stream().mapToInt(i->i).sum();
		System.out.println(sum);
		
		int sum2 = lst.stream().mapToInt(i->i).reduce(1, (a,b)->a*b);
		System.out.println(sum2);
	}

}
