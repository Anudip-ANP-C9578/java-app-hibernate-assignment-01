package org.anudip;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import org.anudip.javaapp.dao.DepartmentDao;
import org.anudip.javaapp.dao.DepartmentDaoImpl;
import org.anudip.javaapp.dao.EmployeeDao;
import org.anudip.javaapp.dao.EmployeeDaoImpl;
import org.anudip.javaapp.entity.Department;
import org.anudip.javaapp.entity.Employee;
import org.anudip.javaapp.utility.HibernateUtility;

public class App {
	public static void main(String[] args) throws ParseException {

		// Performing the operations of adding 5 employees and 3 departments here.

		// creating object of EmployeeDaoImpl class.
		EmployeeDao employeeDao = new EmployeeDaoImpl();

		// setting date format
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date joiningDate = sdf.parse("2020-09-24");

		// Inserting 1 employee record.
		Employee employee1 = new Employee("Ameeda", "M", joiningDate);

		System.out.println(employeeDao.insertEmployee(employee1));

		System.out.println("==========");

		// Inserting multiple employee records.
		Employee employee2 = new Employee("Anu", "Radha", sdf.parse("2019-08-16"));
		Employee employee3 = new Employee("Swapna", "K", sdf.parse("2017-06-16"));
		Employee employee4 = new Employee("Kavya", "R", sdf.parse("2016-09-15"));
		Employee employee5 = new Employee("Appu", "K", sdf.parse("2020-10-23"));

		HashSet<Employee> employeesSet = new HashSet<>();
		employeesSet.add(employee2);
		employeesSet.add(employee3);
		employeesSet.add(employee4);
		employeesSet.add(employee5);

		System.out.println(employeeDao.insertEmployees(employeesSet));

		System.out.println("==========");

		// Updating employee last name
		System.out.println(employeeDao.updateEmployeeLastName(2, "M"));

		System.out.println("==========");

		// Updating employee date of joining
		Date newJoiningDate = sdf.parse("2021-09-18");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(newJoiningDate);
		System.out.println(employeeDao.updateEmployeeDateOfJoining(2, calendar));

		System.out.println("=========");

		// Deleting a employee data
		System.out.println(employeeDao.deleteEmployeeById(5));

		System.out.println("==========");

		// Fetching employee details
		Employee employee = employeeDao.selectEmployeeById(1);
		if (employee != null) {
			System.out.println("Employee Found");
			System.out.println("Employee Id : " + employee.getEmployeeId());
			System.out.println("Employee First Name : " + employee.getFirstName());
			System.out.println("Employee Last Name : " + employee.getLastName());
			System.out.println("Employee Date Of Joining : " + employee.getDateOfJoining());
		} else {
			System.out.println("Employee Not Found");
		}

		System.out.println("=========");

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

		// Updating department head
		System.out.println(departmentDao.updateDepartmentHead(2, "Rekha"));

		System.out.println("=========");

		// Deleting a department data
		System.out.println(departmentDao.deleteDepartmentById(3));

		System.out.println("=========");

		// Fetching department details
		Department department = departmentDao.selectDepartmentById(1);
		if (department != null) {
			System.out.println("Department Found");
			System.out.println("Department Id : " + department.getDepartmentId());
			System.out.println("Department Name : " + department.getName());
			System.out.println("Department Head : " + department.getHead());
		} else {
			System.out.println("Department Not Found");
		}

		HibernateUtility.shutdown();
	}
}