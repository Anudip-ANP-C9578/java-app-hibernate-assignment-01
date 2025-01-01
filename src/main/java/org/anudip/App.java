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

		// Performing the operations of adding 5 employees and 3 departments here.

		// creating object of EmployeeDaoImpl class.
		EmployeeDao employeeDao = new EmployeeDaoImpl();

		// Inserting 1 employee record.
		Employee employee1 = new Employee("Ameeda", "M", "2024-09-17");

		System.out.println(employeeDao.insertEmployee(employee1));

		System.out.println("==========");

		// Inserting multiple employee records.
		Employee employee2 = new Employee("Anu", "Radha", "2019-08-16");
		Employee employee3 = new Employee("Swapna", "K", "2017-06-16");
		Employee employee4 = new Employee("Kavya", "R", "2016-09-15");
		Employee employee5 = new Employee("Appu", "K", "2020-10-23");

		HashSet<Employee> employeesSet = new HashSet<>();
		employeesSet.add(employee2);
		employeesSet.add(employee3);
		employeesSet.add(employee4);
		employeesSet.add(employee5);

		System.out.println(employeeDao.insertEmployees(employeesSet));

		System.out.println("==========");

		// creating object of DepatmentDaoImpl class
		DepartmentDao departmentDao = new DepartmentDaoImpl();

		// Inserting 1 department record.
		Department department1 = new Department("Mathematics", "Rashmi");

		System.out.println(departmentDao.insertDepartment(department1));

		System.out.println("==========");

		// Inserting multiple department records.
		Department department2 = new Department("Computer Science", "Renuka");
		Department department3 = new Department("Physics", "Manjula");

		HashSet<Department> departmentsSet = new HashSet<>();
		departmentsSet.add(department2);
		departmentsSet.add(department3);

		System.out.println(departmentDao.insertDepartments(departmentsSet));
	}
}