package org.anudip.java.dao;

import org.anudip.java.entity.Department;
import java.util.HashSet;


     /* Define an implementation class for this interface
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
		public String insertDepartment(HashSet<Department> departmentsSet);
		String insertDepartment1(Department department);
	    String insertDepartments(HashSet<Department> departmentsSet);
	}
	


