package com.spring.practice.exceptionhandler.service;

import com.spring.practice.exceptionhandler.entity.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployee(Long id);

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long id);
}
