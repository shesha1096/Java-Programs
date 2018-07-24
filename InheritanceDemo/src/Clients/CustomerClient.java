package Clients;

import java.util.ArrayList;
import java.util.List;

import basic.Customer;
import basic.Utility;

public class CustomerClient {
	public static void main(String[] args)
	{
		List<Customer> customerList = new ArrayList<>();
		Customer customer1 = new Customer("9686225035","Shesha",22);
		Customer customer2 = new Customer("9901900362","Shankar",22);
		Customer customer3 = new Customer("9900106892","Java",22);
		customerList.add(customer1);
		customerList.add(customer2);
		customerList.add(customer3);
		for(Customer customer: customerList)
		{
			System.out.println("ID: "+customer.getCustomerID()+" Name: "+customer.getName()+" Contact Number: "+customer.getMobNo());
		}
		Utility.printDetails(customer2);
	}
		

}
