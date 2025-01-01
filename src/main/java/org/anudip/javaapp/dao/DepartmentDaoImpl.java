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

	    try (Session session = sessionFactory.openSession()) {
	        Transaction transaction = session.beginTransaction();

	        // Save each employee from the HashSet
	        for (Department employee : departmentsSet) {
	            session.save(employee);
	        }

	        transaction.commit();
	        isInserted = "Department Inserted Successfully";
	    } catch (Exception e) {
	        e.printStackTrace();
	        isInserted = "Department Insertion Failed due to Exception: " + e.getMessage();
	    }

	    return isInserted;
	}
}

