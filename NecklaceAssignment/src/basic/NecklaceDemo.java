package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NecklaceDemo {
	private static List<Pearl> neckLace = new ArrayList<>();
	public static void main(String args[])
	{
		
		Pearl pearl = new Pearl("Red","Big","Round");
		neckLace.add(pearl);
		Boolean flag = true;
		Scanner sc = new Scanner(System.in);
		
		while(flag)
		{
			Pearl p = new Pearl();
			System.out.println("Enter the colour of the pearl");
			p.setColour(sc.next());
			System.out.println("Enter the size of the pearl");
			p.setSize(sc.next());
			System.out.println("Enter the shape of the pearl");
			p.setShape(sc.next());
			neckLace.add(p);
			System.out.println("Do you wish to continue? Yes->yes, No->no");
			String choice = sc.next();
			if(choice.equals("yes"))
				flag = true;
			else
				flag = false;
			
		}
		displayDetails();
		
	}
	 static void displayDetails()
	{
	for(Pearl pearls: neckLace)
	{
		System.out.println("Colour: "+pearls.getColour()+" Shape: "+pearls.getShape()+" Size: "+pearls.getSize());
		
	}
	System.out.println("Number of pearls added: "+neckLace.size());
	}
	
}
