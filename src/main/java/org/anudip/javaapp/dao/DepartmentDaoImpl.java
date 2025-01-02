package org.anudip.javaapp.dao;

import java.util.HashSet;
import java.util.List;

import org.anudip.javaapp.entity.Department;
import org.anudip.javaapp.entity.Employee;
import org.anudip.javaapp.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DepartmentDaoImpl implements DepartmentDao {

	private SessionFactory sessionFactory;

	// Constructor to initialize Hibernate SessionFactory
	public DepartmentDaoImpl() {

	}

	@Override
	public boolean insertDepartment(Department department) {
		boolean isInserted = false;
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(department);

		transaction.commit();
		isInserted = true;

		session.close();

		return isInserted;
	}

	@Override
	public boolean insertDepartments(HashSet<Department> departmentsSet) {
		boolean isInserted = false;
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		for (Department department : departmentsSet) {
			session.save(department);
		}

		transaction.commit();
		isInserted = true;

		session.close();

		return isInserted;
	}

	@Override
	public boolean updateDepartmentHead(int departmentId, String deptHead) {
		boolean isUpdated = false;

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Department department = session.get(Department.class, departmentId);

		if (department != null) {

			department.setDeptHead(deptHead);

			session.update(department);

			transaction.commit();
			isUpdated = true;
		}

		session.close();

		return isUpdated;
	}

	@Override
	public boolean deleteDepartmentById(int departmentId) {
		boolean isDeleted = false;

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Department department = new Department();
		department.setDepartmentId(departmentId);

		session.delete(department);

		transaction.commit();
		isDeleted = true;

		session.close();

		return isDeleted;
	}

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