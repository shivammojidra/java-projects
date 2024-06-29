package helloworld;

public class AnonymousClassPractice {

	public static void main(String[] args) {
		Runnable r= ()->System.out.println("Hello Child Thread"); // This is lambda exp implementation of object of anonymous child class which implements Runnable interface
		
		Thread t1 = new Thread(r);
		t1.start();
		
		System.out.println("Hello Main Thread");
	}

}
