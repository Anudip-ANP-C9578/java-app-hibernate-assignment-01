package org.anudip.javaapp.dao;

import java.util.HashSet;

import org.anudip.javaapp.entity.Employee;

/*
 * define an implementation class for this interface
 * and override these methods in it to perform the relevant operations.
 */
public interface EmployeeDao {
	public String insertEmployee(Employee employee);
	public String insertEmployees(HashSet<Employee> employeesSet);
}