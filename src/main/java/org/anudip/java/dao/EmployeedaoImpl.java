package org.anudip.java.dao;

import org.anudip.java.entity.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.HashSet;
public class EmployeedaoImpl implements EmployeeDao {
 private SessionFactory sessionFactory;
 public EmployeedaoImpl() {
     // Configure Hibernate session factory
    sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
 }
 @Override
 public String insertEmployee(Employee employee) {
     Transaction transaction = null;
     try (Session session = sessionFactory.openSession()) {
         transaction = session.beginTransaction();
         session.save(employee); // Save the employee entity
         transaction.commit();
         return "Employee inserted successfully.";
     } catch (Exception e) {
         if (transaction != null) transaction.rollback();
         e.printStackTrace();
         return "Error inserting employee: " + e.getMessage();
     }
 }
 @Override
 public String insertEmployees(HashSet<Employee> employeesSet) {
     Transaction transaction = null;
     try (Session session = sessionFactory.openSession()) {
         transaction = session.beginTransaction();
         for (Employee employee : employeesSet) {
             session.save(employee); // Save each employee in the set
         }
         transaction.commit();
         return "All employees inserted successfully.";
     } catch (Exception e) {
         if (transaction != null) transaction.rollback();
         e.printStackTrace();
         return "Error inserting employees: " + e.getMessage();
     }
 }
@Override
public String insertEmployees1(HashSet<Employee> employeesSet) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public String insertEmployee1(Employee employee) {
	// TODO Auto-generated method stub
	return null;
}
}


