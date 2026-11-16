package com.cust.customerproject.customerservices;


import java.util.List;

import org.springframework.stereotype.Service;

import com.cust.customerproject.entity.Employee;
import com.cust.customerproject.exception.EmployeeNotFoundException;
import com.cust.customerproject.repository.EmployeeRepository;

@Service
public class EmployeeService1 implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService1(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer employeeId) {
        return repository.findById(employeeId)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee not found with ID : " + employeeId));
    }

    @Override
    public Employee updateEmployee(Integer employeeId, Employee employee) {

        Employee oldEmployee = repository.findById(employeeId)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee not found with ID : " + employeeId));

        oldEmployee.setEmployeeName(employee.getEmployeeName());
        oldEmployee.setDesignation(employee.getDesignation());
        oldEmployee.setSalary(employee.getSalary());

        return repository.save(oldEmployee);
    }

    @Override
    public String deleteEmployee(Integer employeeId) {

        Employee employee = repository.findById(employeeId)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee not found with ID : " + employeeId));

        repository.delete(employee);

        return "Employee deleted successfully.";
    }
}