package Clients;

import java.util.ArrayList;
import java.util.List;

import basic.Employee;

public class EmployeeClient {
	public static void main(String args[])
	{
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("Developer","Shesha",22));
		employeeList.add(new Employee("Developer","Shankar",22));
		employeeList.add(new Employee("Developer","Satish",22));
		for(Employee employee: employeeList)
		{
			System.out.println("Designation: "+employee.getDesignation()+" Name: "+employee.getName()
			+" Age: "+employee.getAge()+" ID: "+employee.getEmpID());
		}
	}

}
