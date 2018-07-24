package InterfacesDemo;

import java.util.Scanner;

public class InterfaceClient {
	public static void main(String[] args)
	{
		 int a[]= new int[10];
		Scanner sc = new Scanner(System.in);
		MyArrayList myArrayList = new MyArrayList();
		for(int i=0;i<10;i++)
		{
			System.out.println("Enter the element to be inserted at index "+(i+1));
			myArrayList.add(sc.nextInt());
			a[i] = myArrayList.get(i+1);
			System.out.println(a[i]);
			
			
			
		}
		MySortedList mySortedList = new MySortedList(a);
		mySortedList.sort(a);
	}

}
