package Clients;

import basic.Customer;
import basic.Person;
import basic.Utility;

public class PersonClient {
	public static void main(String[] args)
	{
		Customer customer = new Customer("9686225035","Shesha",22);
		System.out.println(customer.getCustomerID());
		Person person = new Person("Shesha",22);
		Utility.printDetails(person);
	}

}
