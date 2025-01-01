package org.anudip.javaapp.dao;

import java.util.HashSet;

import org.anudip.javaapp.entity.Employee;

public interface EmployeeDao {
    String insertEmployee(Employee employee);
    String insertEmployees(HashSet<Employee> employeesSet);
}
       