package com.threading.examples;

class Logic

{

	private int number;

	private int a[]={2,1,2,3,4,5,3,2,1};

	private boolean flag=false;

	

	public synchronized void readNum()

	{

		for(int i=0;i<a.length;i++)

		{

			if(flag)

				try {

					wait();

				} catch (InterruptedException e) {

					// TODO Auto-generated catch block

					e.printStackTrace();

				}

			number=a[i];

			System.out.println("Number Read is:"+number);

			flag=true;

			try {

				Thread.sleep(500);

			} catch (InterruptedException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

			notify();

		}

	}

	

	public synchronized void fact()

	{

		while(true){

		long fact=1;

		if(!flag)

			try {

				wait();

			} catch (InterruptedException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		for(int i=1;i<=number;i++)

		{

			fact=fact*i;

		}

		System.out.println("Fact of :"+number+"is.."+fact);

		flag=false;

		notify();

		}

	}

}

 