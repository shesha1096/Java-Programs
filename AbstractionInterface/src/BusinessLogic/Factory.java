package BusinessLogic;

import basic.Circle;
import basic.Rectangle;
import basic.Shape;

public class Factory {
	public static Shape getInstance(String choice)
	{
		Shape shape=null;
		switch(choice)
		{
		case "R": 
			shape = new Rectangle();
			break;
		case "C":
			shape = new Circle();
			break;

		}
		return shape;

	}

}
