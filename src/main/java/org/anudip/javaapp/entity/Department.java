package org.anudip.javaapp.entity;

/*
 * Complete the entity class with properties as departmentId, name, head
 */
public class Department {

	private int departmentId;
	private String deptName;
	private String deptHead;

	// Constructor
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(int departmentId, String deptName, String deptHead) {
		super();
		this.departmentId = departmentId;
		this.deptName = deptName;
		this.deptHead = deptHead;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptHead() {
		return deptHead;
	}

	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}
}