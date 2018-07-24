package com.bean;

public class Department {
	private Long deptId;
	private String deptName;
	public Department() {
		super();
	}
	public Department( String deptName) {
		super();
		this.deptName = deptName;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	

}
