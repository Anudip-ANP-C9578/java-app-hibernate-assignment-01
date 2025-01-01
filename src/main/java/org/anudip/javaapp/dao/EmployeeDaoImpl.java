package org.anudip.javaapp.dao;

import java.util.HashSet;

import org.anudip.javaapp.entity.Employee;
import org.anudip.javaapp.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//Implementation class for interface EmployeeDao
public class EmployeeDaoImpl implements EmployeeDao {

	// Method to insert a employee in table.
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
}