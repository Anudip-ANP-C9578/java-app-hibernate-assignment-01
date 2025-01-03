package org.anudip.java.dao;

import java.util.HashSet;
import org.anudip.java.entity.Employee;

	/*
	 * Define an implementation class for this interface
	 * and override these methods in it to perform the relevant operations.
	 */
	public interface EmployeeDao {
		/*
		 * This method must insert an employee in the table.
		 */
		public String insertEmployee(Employee employee);
		/*
		 * This method must insert multiple employees in the table.
		 */
		public String insertEmployees1(HashSet<Employee> employeesSet);
	
	    String insertEmployee1(Employee employee);
	    String insertEmployees(HashSet<Employee> employeesSet);
	
	       
}
