package com.threading.examples;

public class FactorialDemo {
	public static void main(String[] args)
	{
		Factorial factorial1 = new Factorial();
		factorial1.setName("Thread1");
		Factorial factorial2 = new Factorial();
		factorial2.setName("Thread2");
		factorial1.start();
		
		factorial2.start();
	}

}
