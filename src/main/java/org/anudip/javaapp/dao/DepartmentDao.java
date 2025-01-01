package org.anudip.javaapp.dao;

import java.util.HashSet;

import org.anudip.javaapp.entity.Department;

/*
 * Define an implementation class for this interface
 * and override these methods in it to perform the relevant operations.
 */
public interface DepartmentDao {
	/*
	 * This method must insert a department in the table.
	 */
	public String insertDepartment(Department department);

	/*
	 * This method must insert multiple departments in the table.
	 */
	public String insertDepartments(HashSet<Department> departmentsSet);
}