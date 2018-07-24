package Clients;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import basic.Employee;
import basic.Manager;
import basic.Utility;

public class ManagerClient {
	public static void main(String[] args)
	{
		List<Manager> employeeList = new ArrayList<>();
		employeeList.add(new Manager("Inventory Management","Shesha",22));
		employeeList.add(new Manager("Cloud Computing","Shankar",22));
		employeeList.add(new Manager("Networking","Satish",22));
		for(Manager manager: employeeList)
		{
			System.out.println("Designation: "+manager.getDesignation()+" Name: "+manager.getName()
			+" Age: "+manager.getAge()+" ID: "+manager.getEmpID());
			System.out.println(manager.getDepartment());
			Utility.printDetails(manager);
		}
		
		
	}

}
