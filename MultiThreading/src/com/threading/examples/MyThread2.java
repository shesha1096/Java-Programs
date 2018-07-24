package com.threading.examples;

public class MyThread2 extends Thread{
	private Account account;
	public MyThread2(Account account)
	{
		this.account = account;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		account.randomNumbers();
		
	}

	
	
	

}
