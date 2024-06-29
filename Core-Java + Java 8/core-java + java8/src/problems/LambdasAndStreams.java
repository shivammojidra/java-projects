package problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class LambdasAndStreams {
	
	public static String listToCommaSeparatedString(ArrayList<Integer> intList) {
		List<String> strList =  intList.stream().map(p->p%2==0?"e"+p:"o"+p).collect(Collectors.toList());
//		System.out.println(strList);
		StringJoiner sJoiner = new StringJoiner(",");
		for (String string : strList) {
			sJoiner.add(string);
		} 
		return sJoiner.toString();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter The numbers in comma separated Format(1,2,3,4....):");
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
			// TODO: handle exception
			System.out.println("Hii I'm Exception "+e);
		}
		
		String str1[] = str.split(",");
		
		ArrayList<Integer> lst = new ArrayList<>();
		for(String s:str1){
			if(s!="") 
				lst.add(Integer.valueOf(s));
		}
		
//		System.out.println("Enter Size of List: ");
//		int size = scanner.nextInt();
		
//		ArrayList<Integer> lst = new ArrayList<>(size);
//		System.out.println("Enter The Elements of List: ");
//		for(int i = 0;i < size;i++) {
//			lst.add(scanner.nextInt());
//		}
//		lst.add(2);
//		lst.add(22);
//		lst.add(21);
//		lst.add(3);
		System.out.println("After Applying Function:");
		System.out.println(listToCommaSeparatedString(lst));

	}


}
