package org.anudip;

import java.time.LocalDate;
import java.util.HashSet;
import org.anudip.javaapp.dao.DepartmentDao;
import org.anudip.javaapp.dao.DepartmentDaoImpl;
import org.anudip.javaapp.dao.EmployeeDao;
import org.anudip.javaapp.dao.EmployeeDaoImpl;
import org.anudip.javaapp.entity.Department;
import org.anudip.javaapp.entity.Employee;
import org.anudip.javaapp.utility.HibernateUtility;

public class App {
	public static void main(String[] args) {
		// Instantiate DAOs
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		DepartmentDao departmentDao = new DepartmentDaoImpl();

	/*	// Create a set of employees
		HashSet<Employee> employeeSet = new HashSet<>();
		employeeSet.add(new Employee("Michael", "Jordan", LocalDate.parse("2023-08-25")));
		employeeSet.add(new Employee("Cobbin", "N", LocalDate.parse("2022-08-22")));
		employeeSet.add(new Employee("Alvin", "Johnson", LocalDate.parse("2024-10-19")));
		employeeSet.add(new Employee("Ravi", "Kumar", LocalDate.parse("2021-04-19")));
		employeeSet.add(new Employee("Ben", "GoldBerg", LocalDate.parse("2024-11-20")));

		// Create a set of departments
		HashSet<Department> departmentSet = new HashSet<>();
		departmentSet.add(new Department("Design", "Alvin_Johnson"));
		departmentSet.add(new Department("Tax", "Ben_GoldBerg"));
		departmentSet.add(new Department("Software", "Michael_Jordan")); 
		
		// Insert employees
		String employeeInsertionResult = employeeDao.insertEmployees(employeeSet);
		System.out.println(employeeInsertionResult);

		// Insert departments
		String departmentInsertionResult = departmentDao.insertDepartments(departmentSet);
		System.out.println(departmentInsertionResult);  
	*/

	System.out.println(employeeDao.updateEmployeeLastName(11, "Pink"));
	LocalDate parsedDate = LocalDate.parse("2024-10-29");
	System.out.println(employeeDao.updateEmployeeDateOfJoining(9, parsedDate));
	System.out.println(employeeDao.deleteEmployeeById(14));

	Employee employee = employeeDao.selectEmployeeById(5);
	if (employee != null) {
		System.out.println("Employee found");

		System.out.println("Student ID:" + employee.getEmployeeId());
		System.out.println("First Name:" + employee.getFirstName());
		System.out.println("Last Name:" + employee.getLastName());
	} else {
		System.out.println("Employee not found");
	}

	System.out.println(departmentDao.updateDepartmentHead(6, "Joe"));
	System.out.println(departmentDao.deleteDepartmentById(8));

	Department department = departmentDao.selectDepartmentById(3);
	if (department != null) {
		System.out.println("Department found");

		System.out.println("Department ID:" + department.getDepartmentId());
		System.out.println("Department Name:" + department.getDepartmentName());
		System.out.println("Head:" + department.getHead());
	} else {
		System.out.println("Department not found");
	}

	HibernateUtility.shutdown();
	}
}
