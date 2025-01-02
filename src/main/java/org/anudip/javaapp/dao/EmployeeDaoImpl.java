package org.anudip.javaapp.dao;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

import org.anudip.javaapp.entity.Employee;
import org.anudip.javaapp.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDaoImpl implements EmployeeDao {

	private SessionFactory sessionFactory;

	// Constructor to initialize Hibernate SessionFactory
	public EmployeeDaoImpl() {

	}

	@Override
	public boolean insertEmployee(Employee employee) {
		boolean isInserted = false;

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(employee);

		transaction.commit();
		isInserted = true;

		session.close();

		return isInserted;
	}

	@Override
	public boolean insertEmployees(HashSet<Employee> employeesSet) {
		boolean isInserted = false;

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		for (Employee employee : employeesSet) {
			session.save(employee);
		}

		transaction.commit();
		isInserted = true;

		session.close();

		return isInserted;
	}

	@Override
	public boolean updateEmployeeLastName(int employeeId, String lastName) {
		boolean isUpdated = false;

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee employee = session.get(Employee.class, employeeId);

		if (employee != null) {

			employee.setLast_Name(lastName);

			session.update(employee);

			transaction.commit();
			isUpdated = true;
		}

		session.close();

		return isUpdated;
	}

	@Override
	public boolean updateEmployeeDateOfJoining(int employeeId, String dateOfJoining) {
		boolean isUpdated = false;

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee employee = session.get(Employee.class, employeeId);

		if (employee != null) {

			employee.setDateofjoin(dateOfJoining);

			session.update(employee);

			transaction.commit();
			isUpdated = true;
		}

		session.close();

		return isUpdated;
	}

	@Override
	public boolean deleteEmployeeById(int employeeId) {
		boolean isDeleted = false;

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee employee = new Employee();
		employee.setEmployee_Id(employeeId);

		session.delete(employee);

		transaction.commit();
		isDeleted = true;

		session.close();

		return isDeleted;

	}

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