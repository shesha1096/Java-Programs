package basic;

public class Manager extends Employee {
	private String department;
	

	public Manager() {
		super();
	}


	public Manager(String department,String name,int age) {
		super("Manager",name,age);
		this.department = department;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}
	public String toString()
	{
		return "ID: "+this.getEmpID();
	}
	
	

}
