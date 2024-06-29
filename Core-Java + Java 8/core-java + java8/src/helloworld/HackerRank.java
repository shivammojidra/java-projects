package helloworld;

//Hackerrank Code Implementation
//URL : https://www.hackerrank.com/challenges/java-lambda-expressions/problem

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

interface PerformOperation {
	 boolean check(int a);
	}

class MyMath {
	 public static boolean checker(PerformOperation p, int num) {
	 return p.check(num);
	}
	 
	// Write your code here

	 public static boolean checkPrime(int n){
		    boolean prime = true;
		    int m = n/2;
		    
		    if(n==0 || n==1){
		        prime = false;
		    }else{
		        for(int i=2;i<m;i++){
		            if(n%i!=0){
		                prime = false;
		                break;
		            }
		        }
		    }
		    
		    return prime;
		}

		public static boolean checkPalindrome(int n){
		    boolean palindrome = true;
		    String num = String.valueOf(n);
		    
		    for(int i=0,j=num.length()-1;i<num.length()/2;i++,j--){
		        if(num.charAt(i)!=num.charAt(j)){
		            palindrome = false;
		            break;
		        }
		    }
		    
		    return palindrome;
		}

		public static PerformOperation isOdd() {
		    PerformOperation pr = (a)-> a%2!=0;
		    return pr;
		}

		public static PerformOperation isPrime() {
		    PerformOperation pr = (a)-> {return checkPrime(a);};
		    return pr;
		}
		public static PerformOperation isPalindrome() {
		    PerformOperation pr = (a)-> checkPalindrome(a);
		    return pr;
		}
}   
	 
//To here

public class HackerRank {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MyMath ob = new MyMath();
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  int T = Integer.parseInt(br.readLine());
		  PerformOperation op;
		  boolean ret = false;
		  String ans = null;
		  while (T--> 0) {
		   String s = br.readLine().trim();
		   StringTokenizer st = new StringTokenizer(s);
		   int ch = Integer.parseInt(st.nextToken());
		   int num = Integer.parseInt(st.nextToken());
		   if (ch == 1) {
		    op = ob.isOdd();
		    ret = ob.checker(op, num);
		    ans = (ret) ? "ODD" : "EVEN";
		   } else if (ch == 2) {
		    op = ob.isPrime();
		    ret = ob.checker(op, num);
		    ans = (ret) ? "PRIME" : "COMPOSITE";
		   } else if (ch == 3) {
		    op = ob.isPalindrome();
		    ret = ob.checker(op, num);
		    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

		   }
		   System.out.println(ans);
		  }

	}

}
