package org.anudip.javaapp.dao;

import java.util.HashSet;
import java.util.Calendar;

import org.anudip.javaapp.entity.Employee;

public interface EmployeeDao {	
		/*
		 * This method insert an employee in the table.
		 */
		public String insertEmployee(Employee employee);
		/*
		 * This method  insert multiple employees in the table.
		 */
		public String insertEmployees(HashSet<Employee> employeesSet);
		/*
		 * This method  update last name of an employee in the table on the basis of employee id.
		 */
		public String updateEmployeeLastName(int employeeId, String lastName);
		/*
		 * This method update date of joining of an employee in the table on the basis of employee id.
		 */
		public String updateEmployeeDateOfJoining(int employeeId, Calendar dateOfJoining);
		/*
		 * This method delete an employee from the table on the basis of employee id.
		 */
		public String deleteEmployeeById(int employeeId);
		/*
		 * This method retrieve an employee record from the table on the basis of employee id.
		 */
		public Employee selectEmployeeById(int employeeId);
	}

       