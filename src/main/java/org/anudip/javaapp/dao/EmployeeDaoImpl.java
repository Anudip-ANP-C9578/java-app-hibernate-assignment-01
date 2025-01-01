package org.anudip.javaapp.dao;

import java.util.HashSet;
import org.anudip.javaapp.entity.Department;
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

	    try (Session session = sessionFactory.openSession()) {
	        Transaction transaction = session.beginTransaction();

	        // Save each employee from the HashSet
	        for (Employee employee : employeesSet) {
	            session.save(employee);
	        }

	        transaction.commit();
	        isInserted = "Employee Inserted Successfully";
	    } catch (Exception e) {
	        e.printStackTrace();
	        isInserted = "Employee Insertion Failed due to Exception: " + e.getMessage();
	    }

	    return isInserted;
	}
}