package org.anudip.javaapp;
import org.anudip.java.dao.DepartmentDao;
import org.anudip.java.dao.DepartmentdaoImpl;
import org.anudip.java.dao.EmployeeDao;
import org.anudip.java.dao.EmployeedaoImpl;
import org.anudip.java.entity.Employee;
import org.anudip.java.entity.Department;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class App {
    public static void main(String[] args) {
    	//Perform the operations of adding 5 employees and 3 departments here.
        try {
            DepartmentdaoImpl departmentDao = new DepartmentdaoImpl();
            EmployeedaoImpl employeeDao = new EmployeedaoImpl();
            // Insert departments
            Department department1 = new Department(4, "Doctor", "Aiims");
            Department department2 = new Department(6, "Nurse", "PrivateHospital");
            Department department3 = new Department(7, "Compouder", "pvt department");
            departmentDao.insertDepartment(department1);
            departmentDao.insertDepartment(department2);
            departmentDao.insertDepartment(department3);
            // Create a date using SimpleDateFormat
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateOfJoining2 = sdf.parse("2025-01-15");
            Date dateOfJoining3 = sdf.parse("2025-11-01");
            Date dateOfJoining4 = sdf.parse("2025-08-20");
            Date dateOfJoining5 = sdf.parse("2024-11-10");
            // Create Employee objects with the parsed date
            Employee employee1 = new Employee(111, "kalpan", "vi", dateOfJoining2);
            Employee employee2 = new Employee(112, "pushpa", "uyu", dateOfJoining3);
            Employee employee3 = new Employee(113, "arun", "de", dateOfJoining4);
            Employee employee4 = new Employee(114, "jitendra", "sa", dateOfJoining5);
            // Add employees to a HashSet for bulk insertion
            HashSet<Employee> employeesSet = new HashSet<>();
            employeesSet.add(employee1);
            employeesSet.add(employee2);
            employeesSet.add(employee3);
            employeesSet.add(employee4);
            // Use the already declared employeeDao
           String result = employeeDao.insertEmployees(employeesSet);
           System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
