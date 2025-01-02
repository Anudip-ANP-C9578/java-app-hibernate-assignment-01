package org.anudip.javaapp.entity;

public class Department {
	private int departmentId;
	private String name;
	private String head;

	// Blank Constructor
	public Department() {
	}

	// Parameterized Constructor with all parameters.
	public Department(int departmentId, String name, String head) {
		this.departmentId = departmentId;
		this.name = name;
		this.head = head;
	}

	// Parameterized Constructor with parameters name, head.
	public Department(String name, String head) {
		this.name = name;
		this.head = head;
	}

	// Getters and Setters
	public int getDepartmentId() {
		return departmentId;
	}

	public String getName() {
		return name;
	}

	public String getHead() {
		return head;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHead(String head) {
		this.head = head;
	}

	// Overriding toString() method
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", name=" + name + ", head=" + head + "]";
	}
}