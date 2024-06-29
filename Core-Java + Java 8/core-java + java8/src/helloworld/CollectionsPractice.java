package helloworld;

import java.util.HashMap;
import java.util.Map;


public class CollectionsPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> map = new HashMap<>();
		
		map.put(1, "goUp");
		map.put(2, "goDown");
		map.put(3, "goLeft");
		map.put(4, "goRight");
		
		for(Map.Entry m:map.entrySet()) {
			System.out.println(m.getKey()+" "+m.getValue());
		}
		
		HashMap<Integer, String> newMap = new HashMap<>();
		
		newMap.put(1, "goGround");
		
		map.putAll(newMap);
		for(Map.Entry m:map.entrySet()) {
			System.out.println(m.getKey()+" "+m.getValue());
		}
		
	}

}
