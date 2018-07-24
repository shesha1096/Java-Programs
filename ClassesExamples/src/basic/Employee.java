package basic;

public class Employee extends Car {
	private String name;
	private int empNo;
	private String companyName;
	public Employee(String name, int empno,String companyName, String carname, String colour)
	{
		super(carname,colour);
		this.companyName = companyName;
		this.name = name;
		this.empNo = empno;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void printInfo()
	{
		System.out.println("Name is:"+name);
		System.out.println("Works for company: "+companyName);
		
	}

}
