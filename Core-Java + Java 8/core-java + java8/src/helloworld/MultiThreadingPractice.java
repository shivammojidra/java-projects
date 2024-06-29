package helloworld;

import java.util.Iterator;

//Example to get Logical Idea on thread...
//Thread implementation with Extending Thread class & Implementing Runnable Interface


//Problem Statement 
//Create 40 threads & run only threads with Odd Thread id & make Threads with even Thread id sleep for 2 seconds(2000ms)


class Test extends Thread{
	public static int cnt=1;
	StringBuffer str = new StringBuffer("This is ");
	@Override
	public void run() {
		try {
			if (this.getId()%2==0) {
				this.sleep(2000);
			}			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		str.append("a new String");
		
		System.out.println(cnt++ +" Running "+this.getName()+" ID: "+this.getId() );
	}
}

class Test2 implements Runnable{
	@Override
	public void run() {
		try {
			if (Thread.currentThread().getId()%2==0) {
				Thread.currentThread().sleep(3000);
			}			
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Running Through Runnable "+Thread.currentThread().getName()+" ID: "+Thread.currentThread().getId());
		
	}
}


public class MultiThreadingPractice {

	public static void main(String[] args) {
		//Thread class & Runnable Interface only run() method , both in java.lang
		
//		Test[] t1 = new Test[40];
		Thread t1[] = new Thread[40];
//		try {
			for(int i=0;i<40;i++) {
				t1[i] = new Test();
				t1[i].start();
//				if (t1[i].getId()%2==0) {
//					t1[i].sleep(2000);
//				}
			}			
//		} catch (Exception e) {
//			System.out.println(e);
//		}
			
		
//		//With Runnable Interface 
////			Test2 test2 = new Test2();
//			Thread th[] = new Thread[40];
//			for(int i=0;i<40;i++) {
//				th[i] = new Thread(new Test2());
//				th[i].start();	
//			}

	}

}
