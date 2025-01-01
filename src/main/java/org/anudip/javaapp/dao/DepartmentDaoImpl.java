package org.anudip.javaapp.dao;

import org.anudip.javaapp.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;

public class DepartmentDaoImpl implements DepartmentDao {

    private SessionFactory sessionFactory;

    public DepartmentDaoImpl() {
        // Configure Hibernate session factory for Department entity
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Department.class).buildSessionFactory();
    }

    @Override
    public String insertDepartment(Department department) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(department); // Save the department entity
            transaction.commit();
            return "Department inserted successfully.";
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback(); // Rollback only if the transaction is active
            }
            e.printStackTrace();
            return "Error inserting department: " + e.getMessage();
        }
    }

    @Override
    public String insertDepartments(HashSet<Department> departmentsSet) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            for (Department department : departmentsSet) {
                session.save(department); // Save each department in the set
            }
            transaction.commit();
            return "All departments inserted successfully.";
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback(); // Rollback only if the transaction is active
            }
            e.printStackTrace();
            return "Error inserting departments: " + e.getMessage();
        }
    }
}
