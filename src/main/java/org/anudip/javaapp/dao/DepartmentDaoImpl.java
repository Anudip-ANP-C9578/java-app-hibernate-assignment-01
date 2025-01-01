package org.anudip.javaapp.dao;

import java.util.HashSet;
import org.anudip.javaapp.entity.Department;
import org.anudip.javaapp.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DepartmentDaoImpl implements DepartmentDao {

	public String insertDepartment(Department department) {
		String isInserted = "Insertion Failed";

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(department);

		transaction.commit();
		isInserted = "Department Inserted Successfully";

		session.close();

		return isInserted;
	}

	public String insertDepartments(HashSet<Department> departmentsSet) {
		String isInserted = "Department Insertion Failed";

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// Save each employee from the HashSet
		for (Department employee : departmentsSet) {
			session.save(employee);
		}

		transaction.commit();
		isInserted = "Department Inserted Successfully";

		session.close();

		return isInserted;
	}

	public String updateDepartmentHead(int departmentId, String head) {
		String isUpdated = "Update failed";

		// Obtain SessionFactory and open a session
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// Retrieve the department by its ID
		Department department = session.get(Department.class, departmentId);

		if (department != null) {
			// Update the department head
			department.setHead(head);
			session.update(department);
			transaction.commit();
			isUpdated = "Updated Successfully.";
		} else {
			isUpdated = "Department not found.";
			transaction.rollback();
		}

		// Close the session
		session.close();

		return isUpdated;
	}

	public String deleteDepartmentById(int departmentId) {
		String isDeleted = "Delete Failed";

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Department department = new Department();
		department.setDepartmentId(departmentId);

		session.delete(department);

		transaction.commit();
		isDeleted = "Deleted Successfully.";

		session.close();

		return isDeleted;
	}

	public Department selectDepartmentById(int departmentId) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Department department = session.get(Department.class, departmentId);
		session.close();

		return department;
	}

}
