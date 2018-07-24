package com.clients;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.Address;
import com.bean.Complaint;
import com.bean.Customer;
import com.bean.Department;
import com.bean.Employee;

public class onetooneClient {
	private static SessionFactory sessionFactory;
	static{
		Configuration config = new Configuration();
		config.configure("/hibernate.cfg.xml");
		sessionFactory = config.buildSessionFactory();
	}

	public static void main(String[] args)
	{
		/*Employee employee = new Employee("Shankar","shankar1096@gmail.com");
		Address address = new Address("Jayanagar","Bangalore","Karnataka","India",employee);
		employee.setAddress(address);
		Department department = new Department("R and D");
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(employee);
		String query = "from Employee as employee where employee.employeeId=?";
		Query queryObject = session.createQuery(query);
		queryObject.setParameter(0, 3L);
		session.save(department);
		List<Employee> employees = queryObject.list();
		for(Employee emp: employees)
		{
			emp.setDepartment(department);
			System.out.println(emp.getDepartment().getDeptName());
		}
		session.getTransaction().commit();
		
		Session session = sessionFactory.openSession();
		Customer customer = new Customer("shankar","shankar1096@gmail.com");
		Complaint complaint1 = new Complaint("Internet not working","NR",new onetooneClient().convert("10-02-2018"),customer);
		Complaint complaint2 = new Complaint("Server Down","R",new onetooneClient().convert("10-02-2018"),customer);
		Complaint complaint3 = new Complaint("System down","NR",new onetooneClient().convert("10-02-2018"),customer);
		List<Complaint> complaintList = new ArrayList<>();
		complaintList.add(complaint1);
		complaintList.add(complaint2);
		complaintList.add(complaint3);
		for(Complaint complaint: complaintList)
		{
			System.out.println(complaint.getStatus());
		}
		customer.setComplaints(complaintList);
		session.getTransaction().begin();
		session.save(customer);
		session.getTransaction().commit();
		*/
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		String query = "from Customer as customer where customer.userName=?";
		Query queryObject = session.createQuery(query);
		queryObject.setParameter(0, "shesha");
		List<Customer> customers = queryObject.list();
		for(Customer c: customers)
		{
			List<Complaint> complaints = c.getComplaints();
			for(Complaint complaint: complaints)
			{
			System.out.println(complaint.getText());
			}
		}
		session.getTransaction().commit();
	}
		
		
		public java.sql.Date convert(String dateString)
		{
			SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
			try {
				
				java.util.Date date = sdf1.parse(dateString);
				java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
				return sqlStartDate;
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
			
			
		}
		
		

}
