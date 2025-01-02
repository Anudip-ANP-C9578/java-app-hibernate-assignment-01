package org.anudip.javaapp.dao;

import org.anudip.javaapp.dao.EmployeeDao;
import org.anudip.javaapp.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.HashSet;
import java.util.Calendar;
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
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.save(employee); // Save the employee
        transaction.commit();
        session.close();
        return "Employee inserted successfully.";
    }

    @Override
    public String insertEmployees(HashSet<Employee> employeesSet) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        for (Employee employee : employeesSet) {
            session.save(employee); // Save each employee
        }
        transaction.commit();
        session.close();
        return "All employees inserted successfully.";
    }

    @Override
    public String updateEmployeeLastName(int employeeId, String lastName) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        Employee employee = session.get(Employee.class, employeeId);
        if (employee != null) {
            employee.setLastName(lastName); // Update last name
            session.update(employee);
        }
        transaction.commit();
        session.close();
        return employee != null ? "Employee last name updated successfully." : "Employee not found.";
    }

    @Override
    public String updateEmployeeDateOfJoining(int employeeId, Calendar dateOfJoining) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        Employee employee = session.get(Employee.class, employeeId);
        if (employee != null) {
            employee.setDateOfJoining(dateOfJoining.getTime()); // Update date of joining
            session.update(employee);
        }
        transaction.commit();
        session.close();
        return employee != null ? "Employee date of joining updated successfully." : "Employee not found.";
    }

    @Override
    public String deleteEmployeeById(int employeeId) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        Employee employee = session.get(Employee.class, employeeId);
        if (employee != null) {
            session.delete(employee); // Delete the employee
        }
        transaction.commit();
        session.close();
        return employee != null ? "Employee deleted successfully." : "Employee not found.";
    }

    @Override
    public Employee selectEmployeeById(int employeeId) {
        Session session = sessionFactory.openSession();
        Employee employee = session.get(Employee.class, employeeId); // Retrieve the employee
        session.close();
        return employee;
    }
}
