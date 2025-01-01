package org.anudip.javaapp.dao;

import java.time.LocalDate;
import java.util.HashSet;
import org.anudip.javaapp.entity.Employee;
import org.anudip.javaapp.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDaoImpl implements EmployeeDao {

	public String insertEmployee(Employee employee) {
		String isInserted = "Insertion Failed";

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(employee);

		transaction.commit();
		isInserted = "Employee Inserted Successfully";

		session.close();

		return isInserted;
	}

	public String insertEmployees(HashSet<Employee> employeesSet) {
		String isInserted = "Employee Insertion Failed";

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// Save each employee from the HashSet
		for (Employee employee : employeesSet) {
			session.save(employee);
		}

		transaction.commit();
		isInserted = "Employee Inserted Successfully";

		return isInserted;
	}

	public String updateEmployeeLastName(int employeeId, String lastName) {
		String isUpdated = "Update failed";

		// Obtain SessionFactory and open a session
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// Retrieve the employee by its ID
		Employee employee = session.get(Employee.class, employeeId);

		if (employee != null) {
			// Update the employee lastname
			employee.setLastName(lastName);
			session.update(employee);
			transaction.commit();
			isUpdated = "Updated Successfully.";
		} else {
			isUpdated = "Employee not found.";
			transaction.rollback();
		}

		// Close the session
		session.close();
		return isUpdated;
	}

	public String updateEmployeeDateOfJoining(int employeeId, LocalDate dateOfJoining) {
		String isUpdated = "Update failed";

		// Obtain SessionFactory and open a session
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// Retrieve the employee by its ID
		Employee employee = session.get(Employee.class, employeeId);

		if (employee != null) {
			// Update the employee dateOfJoining
			employee.setDateOfJoining(dateOfJoining);
			session.update(employee);
			transaction.commit();
			isUpdated = "Updated Successfully.";
		} else {
			isUpdated = "Employee not found.";
			transaction.rollback();
		}

		// Close the session
		session.close();
		return isUpdated;
	}

	public String deleteEmployeeById(int employeeId) {
		String isDeleted = "Delete Failed";

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);

		session.delete(employee);

		transaction.commit();
		isDeleted = "Deleted Successfully.";

		session.close();

		return isDeleted;
	}

	public Employee selectEmployeeById(int employeeId) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee employee = session.get(Employee.class, employeeId);
		session.close();

		return employee;
	}

}
