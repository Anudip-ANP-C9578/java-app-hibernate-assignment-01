package org.anudip.java.entity;

/*
 * Complete the entity class with properties as employeeId, firstName, lastName, dateOfJoining
 */
import java.util.Date;
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private Date dateOfJoining;
    // Default constructor
    public Employee() {}
    // Parameterized constructor
    public Employee(int id, String firstName, String lastName, Date dateOfJoining) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfJoining = dateOfJoining; // Corrected field name
    }
    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public Date getDateOfJoining() {
        return dateOfJoining;
    }
    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
    
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfJoining=" + dateOfJoining +
                '}';
    }
}