package org.anudip.javaapp.dao;

import java.util.HashSet;

import org.anudip.javaapp.entity.Department;
import org.anudip.javaapp.entity.Employee;

/*
 * Define an implementation class for this interface
 * and override these methods in it to perform the relevant operations.
 */
public interface DepartmentDao {
	String insertDepartment(Department department);
    String insertDepartments(HashSet<Department> departmentsSet);
}