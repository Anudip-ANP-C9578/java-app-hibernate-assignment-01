package org.anudip.javaapp.dao;

import java.util.HashSet;

import org.anudip.javaapp.entity.Employee;
import org.anudip.javaapp.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

// Implementation class for EmployeeDao interface, handling database operations for Employee entity.
public class EmployeeDaoImpl implements EmployeeDao {

	// Adds a single employee record to the database.
	@Override
	public String insertEmployee(Employee employee) {
		String result = "Employee insertion failed!";

		// Retrieve the SessionFactory instance from HibernateUtility.
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		// Open a session and begin a transaction.
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// Save the employee record to the database.
		session.save(employee);

		// Commit the transaction and close the session.
		transaction.commit();
		result = "Employee inserted successfully";

		session.close();

		return result;
	}

	// Adds multiple employee records to the database.
	@Override
	public String insertEmployees(HashSet<Employee> employeesSet) {
		String result = "Multiple employees insertion failed!";

		// Retrieve the SessionFactory instance from HibernateUtility.
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		// Open a session and begin a transaction.
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// Save each employee in the provided HashSet to the database.
		for (Employee employee : employeesSet) {
			session.save(employee);
		}

		// Commit the transaction and close the session.
		transaction.commit();
		result = "All employees inserted successfully";

		session.close();

		return result;
	}
}