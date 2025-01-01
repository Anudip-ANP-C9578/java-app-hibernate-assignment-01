package org.anudip.javaapp.entity;

//Entity class
public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String dateOfJoining;

	// Blank Constructor
	public Employee() {
	}

	// Parameterized Constructor with all parameters.
	public Employee(int employeeId, String firstName, String lastName, String dateOfJoining) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfJoining = dateOfJoining;
	}

	// Parameterized Constructor with parameters firstName, lastName, dateOfJoining
	public Employee(String firstName, String lastName, String dateOfJoining) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfJoining = dateOfJoining;
	}

	// Getters and Setters
	public int getEmployeeId() {
		return employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	// Overriding toString() method
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfJoining=" + dateOfJoining + "]";
	}
}