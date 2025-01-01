package org.anudip.javaapp.entity;

/*
 * Complete the entity class with properties as departmentId, name, head
 */
public class Department {
	private int departmentId;
	private String departmentName;
	private String head;
	
	public Department() {
		
	}

	public Department(int departmentId, String departmentName, String head) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.head = head;
	}
	
	public Department(String departmentName, String head) {
		this.departmentName = departmentName;
		this.head = head;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}
	
	

}