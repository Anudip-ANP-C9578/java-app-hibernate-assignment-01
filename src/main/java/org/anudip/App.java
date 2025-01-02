package org.anudip;
import org.anudip.javaapp.dao.EmployeeDao;
import org.anudip.javaapp.dao.EmployeedaoImpl;
import org.anudip.javaapp.entity.Employee;
import org.anudip.javaapp.dao.DepartmentDao;
import org.anudip.javaapp.dao.DepartmentDaoImpl;
import org.anudip.javaapp.entity.Department;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Calendar;

public class App {
    public static void main(String[] args) {
       
        try {
        	// Initialize EmployeeDao
            EmployeeDao employeeDao = new EmployeedaoImpl();
            //initialize DepartmentDao
            DepartmentDao departmentDao = new DepartmentDaoImpl();
            Department department1 = new Department(201, "HR", "Arun");
            Department department2 = new Department(202, "Finance", "Varun");
            Department department3 = new Department(203, "Finance", "Harsha");
 

            // INSERT Operation: Adding multiple departments
            HashSet<Department> departmentSet = new HashSet<>();
            departmentSet.add(department1);
            departmentSet.add(department2);
            departmentSet.add(department3);

            // Insert multiple departments
            String insertResult2 = departmentDao.insertDepartments(departmentSet);
            System.out.println(insertResult2); // Output: All departments inserted successfully.

            // UPDATE Operation: Updating department head
            String updateResult = departmentDao.updateDepartmentHead(201, "Mark Johnson");  // Update department 1's head
            System.out.println(updateResult);  // Output: Department head updated successfully.

            // DELETE Operation: Deleting a department by ID
            String deleteResult = departmentDao.deleteDepartmentById(202);  // Delete department with ID 2
            System.out.println(deleteResult);  // Output: Department deleted successfully.
            // select Operation:
            int departmentId = 201;  // Example department ID to retrieve
            Department department = departmentDao.selectDepartmentById(departmentId);

            if (department != null) {
                System.out.println("Department Details:");
                System.out.println("Department ID: " + department.getDepartmentId());
                System.out.println("Name: " + department.getName());
                System.out.println("Head: " + department.getHead());
            } else {
                System.out.println("Department with ID " + departmentId + " not found.");
            }

            // Insert single employee
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date joiningDate = sdf.parse("2024-12-24");

            Employee employee = new Employee(101, "Pallavi", "N", joiningDate);
            System.out.println(employeeDao.insertEmployee(employee));

            // Insert multiple employees
            HashSet<Employee> employeeSet = new HashSet<>();
            employeeSet.add(new Employee(102, "Pooja", "M", sdf.parse("2024-11-15")));
            employeeSet.add(new Employee(103, "Ethi", "R", sdf.parse("2024-10-10")));
            employeeSet.add(new Employee(104, "Teju", "Y", sdf.parse("2024-09-20")));
            employeeSet.add(new Employee(105, "Bhavya", "M", sdf.parse("2024-08-05")));
            System.out.println(employeeDao.insertEmployees(employeeSet));

            // Update employee last name
            System.out.println(employeeDao.updateEmployeeLastName(101, "Nagendra"));

            // Update employee date of joining
            Date newJoiningDate = sdf.parse("2025-01-01");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(newJoiningDate);
            System.out.println(employeeDao.updateEmployeeDateOfJoining(101, calendar));

            // Select employee by ID
            Employee fetchedEmployee = employeeDao.selectEmployeeById(101);
            if (fetchedEmployee != null) {
                System.out.println("Selected Employee: ");
                System.out.println("ID: " + fetchedEmployee.getId());
                System.out.println("Name: " + fetchedEmployee.getFirstName() + " " + fetchedEmployee.getLastName());
                System.out.println("Date of Joining: " + fetchedEmployee.getDateOfJoining());
            } else {
                System.out.println("Employee not found!");
            }

            // Delete employee by ID
            System.out.println(employeeDao.deleteEmployeeById(105));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
