package org.anudip.javaapp.entity;

public class Department {

    private int departmentId;
    private String name;
    private String head;

    // Constructor
    public Department(int departmentId, String name, String head) {
        this.departmentId = departmentId;
        this.name = name;
        this.head = head;
    }
 // Default constructor (required by Hibernate)
    public Department() {}

    // Getters and Setters
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    // toString method to display department information
    @Override
    public String toString() {
        return "Department [departmentId=" + departmentId + ", name=" + name + ", head=" + head + "]";
    }
}
