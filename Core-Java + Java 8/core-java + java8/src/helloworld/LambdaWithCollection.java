package helloworld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ShoesNew{
	int id;
	String name;
	int price;
	
	public ShoesNew(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public String toString() {
		return id +" "+name+" "+price;
	}
}

public class LambdaWithCollection {

	public static void main(String[] args) {
		List<ShoesNew> shList = new ArrayList<>();
		
		shList.add(new ShoesNew(1,"Bata",1500));
		shList.add(new ShoesNew(2,"Chief",4500));
		shList.add(new ShoesNew(3,"Sparx",1100));
		shList.add(new ShoesNew(4,"Furo",1700));
		shList.add(new ShoesNew(5,"Puma",2500));
		
		System.out.println(shList);
		
		Comparator<ShoesNew> c = (c1,c2)-> c1.price<c2.price? -1 :(c1.price>c2.price)?1:0;
		
		Collections.sort(shList, c);
		System.out.println(shList);
		
		Comparator<ShoesNew> comp1 = (c1,c2)-> c1.name.compareTo(c2.name);//? -1 :(c1.name.compareTo(c2.name))?1:0
		Collections.sort(shList, comp1);
		System.out.println(shList);
	}

}
