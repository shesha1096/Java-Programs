package com.threading.examples;

public class ThreadClient1 {
	public static void main(String[] args)
	{
		Account account = new Account();
		MyThread1 thread1 = new MyThread1(account);
		thread1.setName("One");
		thread1.start();
		MyThread2 thread2 = new MyThread2(account);
		thread2.setName("Two");
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Closing main");
	}

}
