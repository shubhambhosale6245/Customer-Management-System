package com.cust.customerproject.customerservices;


import java.util.List;

import com.cust.customerproject.entity.Employee;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer employeeId);

    Employee updateEmployee(Integer employeeId, Employee employee);

    String deleteEmployee(Integer employeeId);

}

