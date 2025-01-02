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
		Employee employee1 = new Employee(6, "Milli", "Brown", "2023-01-27");
		boolean isEmployeeInserted = employeeDao.insertEmployee(employee1);
		if (isEmployeeInserted) {
			System.out.println("Student Record Inserted Successfully.");
		} else {
			System.out.println("Problem Saving Student Record.");
		}

		// Insert a single department
		Department dept1 = new Department(4, "Sales", "Dom");
		boolean isDepartmentInserted = departmentDao.insertDepartment(dept1);
		if (isDepartmentInserted) {
			System.out.println("Department Record Inserted Successfully.");
		} else {
			System.out.println("Problem Saving Department Record.");
		}

		// Insert multiple employees
		Employee employee2 = new Employee(7, "Will", "Smith", "2024-11-05");
		Employee employee3 = new Employee(8, "Tony", "Stark", "2022-08-20");
		Employee employee4 = new Employee(9, "Chris", "Wanes", "2022-05-19");
		Employee employee5 = new Employee(10, "Peter", "Parker", "2020-08-20");

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
		Department dept3 = new Department(5, "Retail", "Adam");
		Department dept4 = new Department(6, "Manager", "Ewe");

		HashSet<Department> departmentsSet = new HashSet<Department>();
		departmentsSet.add(dept3);
		departmentsSet.add(dept4);

		boolean isDepartmentsInserted = departmentDao.insertDepartments(departmentsSet);
		if (isDepartmentsInserted) {
			System.out.println("Multiple Department Records Inserted Successfully.");
		} else {
			System.out.println("Problem Saving Multiple Department Records.");
		}

		// update Department Head on basis of department ID
		System.out.println(departmentDao.updateDepartmentHead(1, "William"));

		// update lastname of employee
		System.out.println(employeeDao.updateEmployeeLastName(1, "Lana"));

		// update dataofjoin of employee
		System.out.println(employeeDao.updateEmployeeDateOfJoining(2, "2024-02-11"));

		// delete department by ID
		System.out.println(departmentDao.deleteDepartmentById(3));

		// delete employee by ID
		System.out.println(employeeDao.deleteEmployeeById(5));

		// Retrieving department by ID
		Department department = departmentDao.selectDepartmentById(1);

		if (department != null) {
			System.out.println("Department Found,");

			System.out.println("Department ID: " + department.getDepartment_Id());
			System.out.println("Department Name: " + department.getDept_Name());
			System.out.println("Department Head: " + department.getDeptHead());
		} else {
			System.out.println("Department Not Found.");
		}

		// Retrieving employee by ID
		Employee employee = employeeDao.selectEmployeeById(100);

		if (employee != null) {
			System.out.println("Employee Found,");

			System.out.println("Employee ID: " + employee.getEmployee_Id());
			System.out.println("First Name: " + employee.getFirst_Name());
			System.out.println("Last Name: " + employee.getLast_Name());
			System.out.println("Date of Join: " + employee.getDateofjoin());
		} else {
			System.out.println("Employee Not Found.");
		}
	}
}