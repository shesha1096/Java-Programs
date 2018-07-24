package basic;

import java.util.Scanner;

public class FlowersDemo {
	public static void main(String[] args)
	{
		Flower flower = new Flower("Red","Big","Rose");
		System.out.println("Name of the flower is: "+flower.getName()+",colour of the flower is "
				+flower.getColour()+" and the size of the flower is "+flower.getSize());
		Flower f = new Flower();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the flower");
		f.setName(sc.next());
		System.out.println("Enter the colour of the flower");
		f.setColour(sc.next());
		System.out.println("Enter the size of the flower");
		f.setSize(sc.next());
		System.out.println("Name of the flower: "+f.getName()+",Colour-"+f.getColour()+" Size-"+f.getSize());
	}

}
