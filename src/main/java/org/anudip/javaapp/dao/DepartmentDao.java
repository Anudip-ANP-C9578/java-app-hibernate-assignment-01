package org.anudip.javaapp.dao;

import java.util.HashSet;

import org.anudip.javaapp.entity.Department;

/*
 * define an implementation class for this interface
 * and override these methods in it to perform the relevant operations.
 */
public interface DepartmentDao {
	public String insertDepartment(Department department);
	public String insertDepartments(HashSet<Department> departmentsSet);
}