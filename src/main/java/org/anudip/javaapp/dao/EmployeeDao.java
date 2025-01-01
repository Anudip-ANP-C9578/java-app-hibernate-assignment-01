package org.anudip.javaapp.dao;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashSet;

import org.anudip.javaapp.entity.Employee;

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
	public String insertEmployees(HashSet<Employee> employeesSet);

	/*
	 * This method must update last name of an employee in the table on the basis of
	 * employee id.
	 */
	public String updateEmployeeLastName(int employeeId, String lastName);

	/*
	 * This method must update date of joining of an employee in the table on the
	 * basis of employee id.
	 */
	public String updateEmployeeDateOfJoining(int employeeId, LocalDate dateOfJoining);

	/*
	 * This method must delete an employee from the table on the basis of employee
	 * id.
	 */
	public String deleteEmployeeById(int employeeId);

	/*
	 * This method must retrieve an employee record from the table on the basis of
	 * employee id.
	 */
	public Employee selectEmployeeById(int employeeId);
}