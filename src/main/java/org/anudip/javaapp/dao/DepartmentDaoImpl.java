package org.anudip.javaapp.dao;

import java.util.HashSet;

import org.anudip.javaapp.entity.Department;
import org.anudip.javaapp.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

// This class implements the DepartmentDao interface and provides methods for performing database operations related to the Department entity.
public class DepartmentDaoImpl implements DepartmentDao {

	// Inserts a single department record into the database.
	public String insertDepartment(Department department) {
		String result = "Department insertion failed!";

		// Retrieve the SessionFactory instance from HibernateUtility.
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		// Open a session and begin a transaction.
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// Save the department record in the database.
		session.save(department);

		// Commit the transaction and close the session.
		transaction.commit();
		result = "Department inserted successfully";

		session.close();

		return result;
	}

	// Inserts multiple department records into the database.
	public String insertDepartments(HashSet<Department> departmentsSet) {
		String result = "Multiple departments insertion failed!";

		// Retrieve the SessionFactory instance from HibernateUtility.
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		// Open a session and begin a transaction.
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// Save each department in the provided HashSet into the database.
		for (Department department : departmentsSet) {
			session.save(department);
		}

		// Commit the transaction and close the session.
		transaction.commit();
		result = "All departments inserted successfully";

		session.close();

		return result;
	}
}