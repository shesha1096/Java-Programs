package Client;

import java.util.Scanner;

import BusinessLogic.Factory;
import basic.Circle;
import basic.Rectangle;
import basic.Shape;

public class AbstractionDemo {
	public static void main(String[] args)
	{
		System.out.println("Enter your choice R/C");
		String choice = new Scanner(System.in).next();
		Shape shape = null;
		shape = Factory.getInstance(choice);
		if(shape==null)
		{
			System.out.println("Not implemented");
		}
		else
			shape.draw();
	}

}
