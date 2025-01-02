package org.anudip.javaapp.entity;

/*
 * Complete the entity class with properties as departmentId, name, head
 */
public class Department {

	private int department_Id;
	private String dept_Name;
	private String deptHead;

	// Constructor
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(int departmentId, String deptName, String deptHead) {
		super();
		this.department_Id = departmentId;
		this.dept_Name = deptName;
		this.deptHead = deptHead;
	}

	public int getDepartment_Id() {
		return department_Id;
	}

	public void setDepartment_Id(int department_Id) {
		this.department_Id = department_Id;
	}

	public String getDept_Name() {
		return dept_Name;
	}

	public void setDept_Name(String dept_Name) {
		this.dept_Name = dept_Name;
	}

	public String getDeptHead() {
		return deptHead;
	}

	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}

}