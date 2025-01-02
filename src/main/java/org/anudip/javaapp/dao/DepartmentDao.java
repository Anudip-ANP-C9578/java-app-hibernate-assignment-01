package org.anudip.javaapp.dao;

import org.anudip.javaapp.entity.Department;
import java.util.HashSet;


public interface DepartmentDao {
	/*
	 * This method insert a department in the table.
	 */
    String insertDepartment(Department department);
    /*
	 * This method insert multiple departments in the table.
	 */
    String insertDepartments(HashSet<Department> departmentsSet);
    /*
	 * This method must update head of a department in the table on the basis of
	 * department id.
	 */
    String updateDepartmentHead(int departmentId, String newHead);
    /*
	 * This method must delete a department from the table on the basis of
	 * department id.
	 */
    String deleteDepartmentById(int departmentId);
    /*
	 * This method must retrieve a department record from the table on the basis of
	 * department id.
	 */
    Department selectDepartmentById(int departmentId);
}
