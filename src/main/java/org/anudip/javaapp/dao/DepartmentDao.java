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
	public boolean insertDepartment(Department department);
	/*
	 * This method must insert multiple departments in the table.
	 */
	public boolean insertDepartments(HashSet<Department> departmentsSet);
	/*
	 * This method must update head of a department in the table on the basis of department id.
	 */
	public boolean updateDepartmentHead(int departmentId , String deptHead);
	/*
	 * This method must delete a department from the table on the basis of department id.
	 */
	public boolean deleteDepartmentById(int departmentId);
	/*
	 * This method must retrieve a department record from the table on the basis of department id.
	 */
	public Department selectDepartmentById(int departmentId);
}