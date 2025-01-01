package org.anudip.javaapp.dao;

import java.util.HashSet;

import org.anudip.javaapp.entity.Department;
import org.anudip.javaapp.entity.Employee;
import org.anudip.javaapp.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

// Implementation class for interface DepartmentDao
public class DepartmentDaoImpl implements DepartmentDao {

	// Method to insert a department in table.
	public String insertDepartment(Department department) {
		String result = "Department insertion failed!";

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(department);

		transaction.commit();
		result = "Department inserted successfully";

		session.close();

		return result;
	}

	// Method to insert multiple departments in table.
	public String insertDepartments(HashSet<Department> departmentsSet) {
		String result = "Multiple departments insertion failed!";

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		for (Department department : departmentsSet) {
			session.save(department);
		}

		transaction.commit();
		result = "All departments inserted successfully";

		session.close();

		return result;
	}
}