package com.threading.examples;

import java.util.Random;

public class Account {
	private int sum;
	private boolean flag;
	public Account()
	{
		flag = false;
	}
	public synchronized void randomNumbers()
	{

		
		sum=0;
		Random random = new Random();
		for(int i=0;i<10;i++)
		{
			int randomNumber = random.nextInt(5);
			System.out.println(randomNumber);
			sum+=randomNumber;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		notify();
	}
	public synchronized void printSum()
	{
		if(!flag)
		{
			flag = true;
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Request for printing the sum");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Sum="+sum);
	}
	

}
