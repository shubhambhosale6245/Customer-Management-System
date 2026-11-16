package com.cust.customerproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cust.customerproject.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}