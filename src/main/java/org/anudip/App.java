package org.anudip;

import java.util.HashSet;

import org.anudip.javaapp.dao.DepartmentDao;
import org.anudip.javaapp.dao.DepartmentDaoImpl;
import org.anudip.javaapp.dao.EmployeeDao;
import org.anudip.javaapp.dao.EmployeeDaoImpl;
import org.anudip.javaapp.entity.Department;
import org.anudip.javaapp.entity.Employee;

public class App {
	public static void main(String[] args) {

		// Adding employees and departments using DAO implementations.

		// Create an instance of EmployeeDaoImpl for employee-related operations.
		EmployeeDao employeeDao = new EmployeeDaoImpl();

		// Add a single employee record.
		Employee employee1 = new Employee("Lokesh", "R", "2020-07-20");
		System.out.println(employeeDao.insertEmployee(employee1));

		System.out.println("==========");

		// Add multiple employee records.
		Employee employee2 = new Employee("Deekshitha", "S", "2012-07-21");
		Employee employee3 = new Employee("Rakshitha", "P", "2013-05-30");
		Employee employee4 = new Employee("Ramesh", "V", "2014-02-27");
		Employee employee5 = new Employee("Raju", "O", "2015-11-12");

		HashSet<Employee> employeesSet = new HashSet<>();
		employeesSet.add(employee2);
		employeesSet.add(employee3);
		employeesSet.add(employee4);
		employeesSet.add(employee5);

		System.out.println(employeeDao.insertEmployees(employeesSet));

		System.out.println("==========");

		// Create an instance of DepartmentDaoImpl for department-related operations.
		DepartmentDao departmentDao = new DepartmentDaoImpl();

		// Add a single department record.
		Department department1 = new Department("Mathematics", "Rekha");
		System.out.println(departmentDao.insertDepartment(department1));

		System.out.println("==========");

		// Add multiple department records.
		Department department2 = new Department("Computer Science", "Suresh");
		Department department3 = new Department("Physics", "Usha");

		HashSet<Department> departmentsSet = new HashSet<>();
		departmentsSet.add(department2);
		departmentsSet.add(department3);

		System.out.println(departmentDao.insertDepartments(departmentsSet));
	}
}