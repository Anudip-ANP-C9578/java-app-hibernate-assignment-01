package org.anudip;

import java.util.HashSet;
import org.anudip.javaapp.dao.DepartmentDao;
import org.anudip.javaapp.dao.DepartmentDaoImpl;
import org.anudip.javaapp.dao.EmployeeDao;
import org.anudip.javaapp.dao.EmployeeDaoImpl;
import org.anudip.javaapp.entity.Department;
import org.anudip.javaapp.entity.Employee;

public class App {
    public static void main(String[] args) {
        // Instantiate DAOs
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        DepartmentDao departmentDao = new DepartmentDaoImpl();

        // Create a set of employees
        HashSet<Employee> employeeSet = new HashSet<>();
        employeeSet.add(new Employee("Pooja", "M", "2024-08-21"));
        employeeSet.add(new Employee("Pallavi", "N", "2024-05-22"));
        employeeSet.add(new Employee("Isha", "Gupta", "2024-10-29"));
        employeeSet.add(new Employee("Arvind", "Kumar", "2024-08-19"));
        employeeSet.add(new Employee("Akash", "Naidu", "2023-11-23"));

        // Create a set of departments
        HashSet<Department> departmentSet = new HashSet<>();
        departmentSet.add(new Department("Sales", "Suresh_Gupta"));
        departmentSet.add(new Department("HR", "Pooja_M"));
        departmentSet.add(new Department("Accountant", "Pallavi_N"));

        // Insert employees
        String employeeInsertionResult = employeeDao.insertEmployees(employeeSet);
        System.out.println(employeeInsertionResult);

        // Insert departments
        String departmentInsertionResult = departmentDao.insertDepartments(departmentSet);
        System.out.println(departmentInsertionResult);
    }
}
