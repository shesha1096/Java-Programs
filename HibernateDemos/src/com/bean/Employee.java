package com.bean;

public class Employee {
	private Long employeeId;
	private String name;
	private String email;
	private Address address;
	private Department department;
	public Employee() {
		super();
	}
	public Employee( String name, String email) {
		super();
		this.name = name;
		this.email = email;
		
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return employeeId+" "+name+" "+email;
	}
	

}