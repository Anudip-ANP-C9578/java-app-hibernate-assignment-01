package org.anudip.javaapp.dao;

import java.util.Calendar;
import java.util.HashSet;

import org.anudip.javaapp.entity.Department;
import org.anudip.javaapp.entity.Employee;
import org.anudip.javaapp.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//Implementation class for interface EmployeeDao
public class EmployeeDaoImpl implements EmployeeDao {

	// Method to insert a employee in table.
	@Override
	public String insertEmployee(Employee employee) {
		String result = "Employee insertion failed!";

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(employee);

		transaction.commit();
		result = "Employee inserted successfully";

		session.close();

		return result;
	}

	// Method to insert multiple employees in table.
	@Override
	public String insertEmployees(HashSet<Employee> employeesSet) {
		String result = "Multiple employees insertion failed!";

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		for (Employee employee : employeesSet) {
			session.save(employee);
		}

		transaction.commit();
		result = "All employees inserted successfully";

		session.close();

		return result;
	}

	// Method to update employee last name on the basis of employee id
	@Override
	public String updateEmployeeLastName(int employeeId, String lastName) {
		String result = "Update of employee last name Failed";

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee employee = session.get(Employee.class, employeeId);
		employee.setLastName(lastName);

		session.update(employee);

		transaction.commit();
		result = "Successfully updated employee last name";

		session.close();

		return result;
	}

	// Method to update employee date of joining on the basis of employee id
	@Override
	public String updateEmployeeDateOfJoining(int employeeId, Calendar dateOfJoining) {
		String result = "Update of employee date of joining Failed";

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee employee = session.get(Employee.class, employeeId);
		employee.setDateOfJoining(dateOfJoining.getTime());

		session.update(employee);

		transaction.commit();
		result = "Successfully updated employee date of joining";

		session.close();

		return result;
	}

	// Method to override delete employee on the basis of employee id
	@Override
	public String deleteEmployeeById(int employeeId) {
		String result = "Deletion of employee failed";

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee employee = session.get(Employee.class, employeeId);

		session.delete(employee);

		transaction.commit();
		result = "Successfully deleted employee";

		session.close();

		return result;
	}

	// Method to fetch employee details on the basis of employee id
	@Override
	public Employee selectEmployeeById(int employeeId) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee employee = session.get(Employee.class, employeeId);

		session.close();

		return employee;
	}
}