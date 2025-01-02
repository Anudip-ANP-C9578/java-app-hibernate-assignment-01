package org.anudip.javaapp.entity;

import java.util.Calendar;

/*
 * Complete the entity class with properties as employeeId, firstName, lastName, dateOfJoining
 */
public class Employee {

	private int employeeId;
	private String firstName;
	private String lastName;
	private String dateofjoin;

	// Constructors
	public Employee() {
	}

	public Employee(int employeeId, String firstName, String lastName, String dateofjoin) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateofjoin = dateofjoin;
	}

	// Getters and Setters
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateofjoin() {
		return dateofjoin;
	}

	public void setDateofjoin(String dateOfJoining) {
		this.dateofjoin = dateOfJoining;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateofjoin=" + dateofjoin + "]";
	}
}