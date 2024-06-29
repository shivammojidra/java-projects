package helloworld;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredefinedFI {

	public static void main(String[] args) {
		
		Predicate<Integer> p = i->i%2==0;
		Function<Integer, Integer> f = i->i*i;
		Function<Integer, Double> f2 = i->Math.sqrt(i);
		
		IntUnaryOperator u = i -> i*i;
		
		System.out.println(u.applyAsInt(5));
		
		Integer arr[] = {1,2,4,5,6,7,8,9,10};
		
		//Function Chaining
		for(Integer i : arr) {
			if(p.test(i))
				System.out.println(i+" is Even & its Square is "+f.apply(i)+" Again Sqrt "+f2.apply(f.apply(i))+"  Another Way "+f.andThen(f2).apply(i));
		}
		
		Shoes s1 = new Shoes(1, "Wood Land", 10000);
		
		Consumer<Shoes> c1 = sh -> System.out.println(sh.name+" With Price "+sh.price+" Is about to Show");
		
		c1.accept(s1);
		
		Supplier<String> sup1 = ()-> {
			String otp ="";
			for(int i=0;i<6;i++) {
				otp +=(int)(Math.random()*10);
			}
 			return otp;
		};
		
		System.out.println(sup1.get());

	}

}
