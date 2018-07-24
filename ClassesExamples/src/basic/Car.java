package basic;

public class Car {
	private String carName;
	private String colour;
	public Car(String carname, String colour)
	{
		this.carName = carname;
		this.colour = colour;
	}
	
	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Car() {
		// TODO Auto-generated constructor stub
	}
	public void carInfo()
	{
		System.out.println("Drives a car "+carName+" which is of colour: "+colour);
	}
	

}
