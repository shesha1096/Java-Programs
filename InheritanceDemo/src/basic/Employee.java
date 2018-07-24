package basic;

public class Employee extends Person {
	private int empID;
	private String designation;
	private static int count=0;
	public Employee() {
		super();
		this.empID = ++count;
	}
	
	public Employee(String designation,String name,int age) {
		super(name,age);
		this.empID = ++count;
		this.designation = designation;
	}

	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	

}
