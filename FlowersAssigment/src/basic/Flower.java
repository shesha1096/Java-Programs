package basic;

public class Flower {
	private String colour;
	private String size;
	private String name;
	
	public Flower(String colour, String size, String name) {
		this.colour = colour;
		this.size = size;
		this.name = name;
	}
	
	public Flower() {
		// TODO Auto-generated constructor stub
	}

	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
