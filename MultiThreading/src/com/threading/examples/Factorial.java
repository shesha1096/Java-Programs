package com.threading.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Factorial extends Thread {
	private boolean flag;
	private int counter;
	private int[] numberList;
	public Factorial()
	{
		numberList = new int[]{5,6,7,8,9,10};
		flag = true;
		counter = 0;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		factorialCalculation();
	}
	public synchronized int getRandomNumber()
	{
		if(flag)
		{
			System.out.println("Here too");
			flag = false;
			return numberList[++counter];
			
			
			
		}
		else
		{
			try {
				wait();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
		
		return 0;
	}
	public synchronized void factorialCalculation()
	{
		System.out.println("Here");
		
		
		int i,fact=1;  
		  int number= getRandomNumber();
		  System.out.println(number);
		  for(i=1;i<=number;i++){    
		     fact=fact*i;  
		     }   
		  System.out.println(Thread.currentThread().getName()+"-"+fact);
		  notify();
		}
	

	}


