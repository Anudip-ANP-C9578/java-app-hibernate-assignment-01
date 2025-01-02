package org.anudip.javaapp.dao;
import org.anudip.javaapp.dao.DepartmentDao;

import org.anudip.javaapp.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;

public class DepartmentDaoImpl implements DepartmentDao {

    private SessionFactory sessionFactory;

    public DepartmentDaoImpl() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    @Override
    public String insertDepartment(Department department) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
            return "Department inserted successfully.";
        }
    }

    @Override
    public String insertDepartments(HashSet<Department> departmentsSet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            for (Department department : departmentsSet) {
                session.save(department);
            }
            transaction.commit();
            return "All departments inserted successfully.";
        }
    }

    @Override
    public String updateDepartmentHead(int departmentId, String newHead) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Department department = session.get(Department.class, departmentId);
            if (department != null) {
                department.setHead(newHead);
                session.update(department);
                transaction.commit();
                return "Department head updated successfully.";
            } else {
                return "Department not found.";
            }
        }
    }

    @Override
    public String deleteDepartmentById(int departmentId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Department department = session.get(Department.class, departmentId);
            if (department != null) {
                session.delete(department);
                transaction.commit();
                return "Department deleted successfully.";
            } else {
                return "Department not found.";
            }
        }
    }

    @Override
    public Department selectDepartmentById(int departmentId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Department.class, departmentId);
        }
    }
}
