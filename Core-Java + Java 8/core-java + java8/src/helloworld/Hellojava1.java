package helloworld;


//Problem Statements

//1. print numbers starting with 1 with stream
//2. Find Duplicate numbers with stream
//3. String Joiner Implementation

//4. Stream API & Filter Implementation
//5. Lambda expression Implementation
//6. Date time Implementation
//7. Collection Framework Implementation
//8. Method Reference




import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.Vector;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
interface SampleInter{
//	public String say(String name);
//	public String walk(String name) ;
	public int addition(int a,int b); 
	
}

class Shoes {
	int id;
	String name;
	int price;
	public Shoes(int id,String name,int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	 }
}

class Arithmatic{
	public  int add(int a , int b) {
		System.out.println("Arth class");
		return a+b;
	}
	public static float add(int a , float b) {
		return a+b;
	}
	public static float add(float a , float b) {
		return a+b;
	}
}


public class Hellojava1 {
	
	public static void main(String[] args) {
		
		
		//Stream API & Filter Implementation
		List<Integer> numbers = new ArrayList<>();
		Set<Integer> hSet = new HashSet<>();
		
		numbers.add(1);
		numbers.add(12);
		numbers.add(2);
		numbers.add(4);
		numbers.add(15);
		numbers.add(22);
		numbers.add(10);
		
//		Collections.sort(numbers);
		System.out.println(numbers);
		
		List<Float> discountedList = numbers.stream().map(p->p*0.9f).collect(Collectors.toList()); //to map discounted price here we've calculated 10% discount.
		System.out.println(discountedList);
		
		numbers.stream().sorted(Collections.reverseOrder()).limit(4).forEach(System.out::println);//reverse order
		
		
		Integer maxInteger = numbers.stream().max((a,b)-> a>b ? 1 : -1 ).get();
		
		System.out.println(maxInteger);
		
		//print numbers starting with 1 with stream
		numbers.stream().filter(n->n.toString().charAt(0)=='1').forEach(System.out::println);
		
		//Find Duplicate numbers with stream
		numbers.stream().filter(n-> !hSet.add(n)).forEach(System.out::println);
		
		//Find The first element of the list using stream
		numbers.stream().filter(n-> numbers.indexOf(n)==0).forEach(System.out::println);
		numbers.stream().findFirst().ifPresent(System.out::println); //Alternative
		
		
		//String Joiner Implementation
		StringJoiner joiner = new StringJoiner("-","{","}");
		joiner.add("My");
		joiner.add("new");
		joiner.add("Work");
		joiner.add("Space");
		
//		joiner
		
		System.out.println(joiner);
		
		String myString = joiner.toString();
		System.out.println(myString.getClass());
		
		
		
		//Stream API & Filter Implementation
		List<Shoes> shList = new ArrayList<>();
		
		shList.add(new Shoes(1,"Bata",1500));
		shList.add(new Shoes(2,"Chief",4500));
		shList.add(new Shoes(3,"Sparx",1100));
		shList.add(new Shoes(4,"Furo",1700));
		shList.add(new Shoes(5,"Puma",2500));
		
		Iterator itr = shList.iterator(); //Printing user defined class using iterator
		while (itr.hasNext()) {
			Shoes ele = (Shoes) itr.next();
			System.out.println(ele.id + ele.name + ele.price);
			
		}
		
		List<String> shoe_list_above1500 = shList.stream().filter(s -> s.price>1500 && s.price<3000).map(s -> s.name).collect(Collectors.toList());
		
		Integer total = shList.stream().filter(s->s.price>2000).map(s->s.price).reduce(0,(sum, price)->sum+price);
		
		System.out.println(shoe_list_above1500);
		System.out.println(total);

		
		//Lambda expression Implementation
		SampleInter spInter = (a,b)->(a+b);
//		
		System.out.println(spInter.addition(200, 300));
		
		//Date time Implementation
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt.format(formatter));
		System.out.println(dt.minusDays(1).format(formatter));
		System.out.println(dt.plusDays(2).format(formatter));
		
		//Collection Framework Implementation		
		List<String> vcList = new Vector<String>();
		List<String> arrList1 = new ArrayList<String>();
		
		vcList.add("Mehul");
		vcList.add("Surak");
		vcList.add("Kaya");
		vcList.add("Vasi");
		
		arrList1.add("Mehul");
		arrList1.add("Suraj");
		arrList1.add("Kaya");
		arrList1.add("Vasi");
		
		vcList.forEach(n -> System.out.println(n) );
		arrList1.forEach(n -> System.out.println(n) );
		
		int[] arr = {5,8,1,0,6,9,3,4,2};  
        // Iterating array elements  
        for (int i : arr) {  
            System.out.print(i+" ");  
        }  
        // Sorting array elements parallel  
        Arrays.parallelSort(arr,2,7);  
        System.out.println("\nArray elements after sorting");  
        // Iterating array elements  
        for (int i : arr) {  
            System.out.print(i+" ");  
        }
		
		
		//
		String[] str = new String[10];
		System.out.println(str[5].toString().toUpperCase());
		
		str[5]="HelloGogle";
		if (str[5]!=null) {
//			str[5].toString().toUpperCase();
			System.out.println(str[5].toString().toUpperCase());
		}else {
			System.out.println("It is a null string");
		}
		
		
//		 List<Product> productsList = new ArrayList<Product>();  
//	      
//		 productsList.add(new Product(1,"HP Laptop",25000f));  
//		 productsList.add(new Product(2,"Dell Laptop",30000f));  
//		 productsList.add(new Product(3,"Lenevo Laptop",28000f));  
//		 productsList.add(new Product(4,"Sony Laptop",28000f));  
//		 productsList.add(new Product(5,"Apple Laptop",90000f));  
//		 
////		 Predicate<Product> productPredicate = new Predicate<Product>() {
////
////			@Override
////			public boolean test(Product t) {
////				// TODO Auto-generated method stub
////				return false;
////			}
////		};
//
//
//		Product maxProduct= productsList.stream().max((product1,product2)->product1.price>product2.price?1:-1).get();
//		Product minProduct= productsList.stream().max((product1,product2)->product1.price<product2.price?1:-1).get();
//		
//		System.out.println(maxProduct.name+maxProduct.price);
//		System.out.println(minProduct.name+minProduct.price);
		
		SampleInter sint = new Arithmatic()::add;
		
		Arithmatic art = new Arithmatic();
//		
		SampleInter sampleInter = art::add;
//		
//		
//		System.out.println(sampleInter.add2nums(4, 30));
//		
//		Method Reference
//		BiFunction<Integer, Integer, Integer>adder1 = Arithmatic::add;
		BiFunction<Integer, Float, Float>adder2 = Arithmatic::add;
		BiFunction<Float,Float,Float>adder3 = Arithmatic::add;
//		
//		int result1 = adder1.apply(2, 3);
		float result2 = adder2.apply(2, 30f);
		float result3 = adder3.apply(2f, 3f);
//		
		System.out.println(result2);
		System.out.println(result3);
		
//		List<Product> productList = new ArrayList<Product>();
//		
//		productList.add(new Product(0, "Bata", 1220f));
//		productList.add(new Product(1, "Puma", 2020f));
//		productList.add(new Product(2, "Wood", 3020f));
//		
//		Stream<Product> filtere_data = productList.stream().filter(p->p.price > 1220); 
//		
//		filtere_data.forEach(
//				product -> System.out.println(product.name+":"+product.price)
//				);
//		
////		Collections.sort(productList,(p1,p2)->{
////			return p1.name.compareTo(p2.name);
////		});
//		
//		for(Product p:productList) {
//			System.out.println(p.id+" "+p.name+" "+p.price);
//		}
//		
//		Runnable r1 = new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				System.out.println("Thread1 is running");
//			}
//		};
//		
//		Thread t1 = new Thread(r1);
//		t1.start();
//
//
//		Runnable r2 = ()->{
//			System.out.println("Thread2 is running");
//		};
//		
//		Thread t2 = new Thread(r2);
//		t2.start();
		
		
//		
//		SampleInter s2 = (int a,int b) -> (a+b);
////		System.out.println(s1.walk("Man"));
//		System.out.println(s2.addition(2,3));
//		SampleInter s2 = (name2) -> {
//			return "Hello" + name;
//		};
//		
		ArrayList<Integer> aList = new ArrayList<Integer>();
		
		aList.add(8);
		aList.add(3);
		aList.add(1,12);
		
		List<Integer> aList2 = (ArrayList<Integer>) aList.clone();
		
		aList2.add(4);
		aList.sort(null);
//		List.sort(aList2);
		Iterator<Integer> itrIterator = aList.iterator();
		Iterator<Integer> itrIterator2 = aList2.iterator();
		
		while (itrIterator.hasNext()) {
			System.out.println(itrIterator.next());
		}
		for(Integer singleMember:aList2) {
			System.out.println(singleMember);
		}
		aList2.addAll(1,aList);
		aList2.forEach(a->{
			System.out.println(a);			
		});
		System.out.println("The size of the array is: " + aList2.size()); 
		System.out.println();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		System.out.println(LocalDate.now());
		System.out.println(LocalDateTime.now().format(format));
		System.out.println((LocalDateTime.now().format(DateTimeFormatter.ISO_DATE)).getClass().getSimpleName());
		System.out.println((LocalDateTime.now().format(DateTimeFormatter.ISO_DATE)).getClass().getSimpleName());
		
	}

}
