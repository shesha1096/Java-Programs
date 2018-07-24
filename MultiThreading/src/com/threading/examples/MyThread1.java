package com.threading.examples;

public class MyThread1 extends Thread{
	private Account account;
	public MyThread1()
	{
		
	}
	public MyThread1(Account account)
	{
		this.account = account;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		account.printSum();
		
	}

	
	
	

}
