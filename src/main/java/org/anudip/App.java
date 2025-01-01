package org.anudip;
import org.anudip.javaapp.dao.EmployeeDao;
import org.anudip.javaapp.dao.EmployeedaoImpl;
import org.anudip.javaapp.entity.Employee;
import org.anudip.javaapp.dao.DepartmentDaoImpl;
import org.anudip.javaapp.entity.Department;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class App {
    public static void main(String[] args) {
        try {
            DepartmentDaoImpl departmentDao = new DepartmentDaoImpl();
            EmployeedaoImpl employeeDao = new EmployeedaoImpl();

            // Insert departments
            Department department1 = new Department(1, "HR", "Alice");
            Department department2 = new Department(2, "Finance", "Bob");
            Department department3 = new Department(3, "Sales", "Ram");
            departmentDao.insertDepartment(department1);
            departmentDao.insertDepartment(department2);
            departmentDao.insertDepartment(department3);

            // Create a date using SimpleDateFormat
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateOfJoining2 = sdf.parse("2024-11-15");
            Date dateOfJoining3 = sdf.parse("2024-10-01");
            Date dateOfJoining4 = sdf.parse("2024-09-20");
            Date dateOfJoining5 = sdf.parse("2024-08-10");

            // Create Employee objects with the parsed date
            Employee employee1 = new Employee(102, "Pooja", "M", dateOfJoining2);
            Employee employee2 = new Employee(103, "Ethi", "R", dateOfJoining3);
            Employee employee3 = new Employee(104, "Teju", "Y", dateOfJoining4);
            Employee employee4 = new Employee(105, "Bhavya", "M", dateOfJoining5);

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
