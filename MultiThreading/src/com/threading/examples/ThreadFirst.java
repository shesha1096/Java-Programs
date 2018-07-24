package com.threading.examples;

public class ThreadFirst extends Thread  {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<10;i++)
		{
			System.out.println("Thread: "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
 class ThreadFirstDemo
{
	 public static void main(String[] args)
	 {
		 ThreadFirst first = new ThreadFirst();
		 first.start();
	 for(int i=0;i<10;i++)
	 {
		 System.out.println("Main: "+i);
		 try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	 }
	 }
	
}
