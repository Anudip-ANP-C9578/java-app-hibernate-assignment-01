package org.anudip.javaapp.entity;

/*
 * Complete the entity class with properties as employeeId, firstName, lastName, dateOfJoining
 */
public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String dateOfJoining;

	public Employee() {

	}
	public Employee(int employeeId, String firstName, String lastName, String dateOfJoining) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfJoining = dateOfJoining;
	}
	
	public Employee( String firstName, String lastName, String dateOfJoining) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfJoining = dateOfJoining;
	}
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
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	

}