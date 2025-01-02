package org.anudip.javaapp.entity;

import java.util.Calendar;

/*
 * Complete the entity class with properties as employeeId, firstName, lastName, dateOfJoining
 */
public class Employee {

	private int employee_Id;
	private String first_Name;
	private String last_Name;
	private String dateofjoin;

	// Constructors
	public Employee() {
	}

	public Employee(int employeeId, String firstName, String lastName, String dateofjoin) {
		this.employee_Id = employeeId;
		this.first_Name = firstName;
		this.last_Name = lastName;
		this.dateofjoin = dateofjoin;
	}

	public int getEmployee_Id() {
		return employee_Id;
	}

	public void setEmployee_Id(int employee_Id) {
		this.employee_Id = employee_Id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getDateofjoin() {
		return dateofjoin;
	}

	public void setDateofjoin(String dateofjoin) {
		this.dateofjoin = dateofjoin;
	}

	// Getters and Setters
	
}