package org.anudip;

import java.util.HashSet;

import org.anudip.javaapp.dao.EmployeeDao;
import org.anudip.javaapp.dao.EmployeeDaoImpl;
import org.anudip.javaapp.entity.Employee;
import org.anudip.javaapp.dao.DepartmentDao;
import org.anudip.javaapp.dao.DepartmentDaoImpl;
import org.anudip.javaapp.entity.Department;

public class App {
	public static void main(String[] args) {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		DepartmentDao departmentDao = new DepartmentDaoImpl();

		// Insert a single employee
		Employee employee1 = new Employee(1, "John", "Doe", "2025-01-01");
		boolean isEmployeeInserted = employeeDao.insertEmployee(employee1);
		if (isEmployeeInserted) {
			System.out.println("Student Record Inserted Successfully.");
		} else {
			System.out.println("Problem Saving Student Record.");
		}

		// Insert a single department
		Department dept1 = new Department(1, "HR", "Alice");
		boolean isDepartmentInserted = departmentDao.insertDepartment(dept1);
		if (isDepartmentInserted) {
			System.out.println("Department Record Inserted Successfully.");
		} else {
			System.out.println("Problem Saving Department Record.");
		}

		// Insert multiple employees
		Employee employee2 = new Employee(2, "Jane", "Smith", "2024-12-15");
		Employee employee3 = new Employee(3, "Alice", "Johnson", "2023-11-20");
		Employee employee4 = new Employee(4, "Jade", "Watson", "2022-01-09");
		Employee employee5 = new Employee(5, "Robert", "Junior", "2019-04-30");

		HashSet<Employee> employeesSet = new HashSet<Employee>();
		employeesSet.add(employee2);
		employeesSet.add(employee3);
		employeesSet.add(employee4);
		employeesSet.add(employee5);

		boolean isEmployeesInserted = employeeDao.insertEmployees(employeesSet);
		if (isEmployeeInserted) {
			System.out.println("Student Record Inserted Successfully.");
		} else {
			System.out.println("Problem Saving Student Record.");
		}

		// Insert multiple departments
		Department dept2 = new Department(2, "IT", "Bob");
		Department dept3 = new Department(3, "Finance", "Charlie");

		HashSet<Department> departmentsSet = new HashSet<Department>();
		departmentsSet.add(dept2);
		departmentsSet.add(dept3);

		boolean isDepartmentsInserted = departmentDao.insertDepartments(departmentsSet);
		if (isDepartmentsInserted) {
			System.out.println("Multiple Department Records Inserted Successfully.");
		} else {
			System.out.println("Problem Saving Multiple Department Records.");
		}

		// update Department Head on basis of department ID
		System.out.println(departmentDao.updateDepartmentHead(1, "Alexander"));

		// update lastname of employee
		System.out.println(employeeDao.updateEmployeeLastName(1, "Snow"));

		// update dataofjoin of employee
		System.out.println(employeeDao.updateEmployeeDateOfJoining(1, "2022-01-23"));

		// delete department by ID
		System.out.println(departmentDao.deleteDepartmentById(2));

		// delete employee by ID
		System.out.println(employeeDao.deleteEmployeeById(3));

		// Retrieving department by ID
		Department department = departmentDao.selectDepartmentById(3);

		if (department != null) {
			System.out.println("Department Found,");

			System.out.println("Department ID: " + department.getDepartmentId());
			System.out.println("Department Name: " + department.getDeptName());
			System.out.println("Department Head: " + department.getDeptHead());
		} else {
			System.out.println("Department Not Found.");
		}

		// Retrieving employee by ID
		Employee employee = employeeDao.selectEmployeeById(4);

		if (employee != null) {
			System.out.println("Employee Found,");

			System.out.println("Employee ID: " + employee.getEmployeeId());
			System.out.println("First Name: " + employee.getFirstName());
			System.out.println("Last Name: " + employee.getLastName());
			System.out.println("Date of Join: " + employee.getDateofjoin());
		} else {
			System.out.println("Employee Not Found.");
		}
	}
}