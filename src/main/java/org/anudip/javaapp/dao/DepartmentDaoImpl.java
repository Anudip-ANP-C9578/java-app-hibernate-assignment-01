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
	@Override
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
	@Override
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

	// Method to update department id on the basis of departmentId
	@Override
	public String updateDepartmentHead(int departmentId, String head) {
		String result = "Update of Department Head Failed";

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Department department = session.get(Department.class, departmentId);
		department.setHead(head);

		session.update(department);

		transaction.commit();
		result = "Successfully updated department head";

		session.close();

		return result;
	}

	// Method to delete department on the basis of departmentId
	@Override
	public String deleteDepartmentById(int departmentId) {
		String result = "Deletion of department failed";

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Department department = session.get(Department.class, departmentId);

		session.delete(department);

		transaction.commit();
		result = "Successfully deleted department";

		session.close();

		return result;
	}

	// Method to fetch details of a department on the basis of departmentId
	@Override
	public Department selectDepartmentById(int departmentId) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Department department = session.get(Department.class, departmentId);

		session.close();

		return department;
	}
}