package com.spring.practice.exceptionhandler.repository;

import com.spring.practice.exceptionhandler.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository
        extends CrudRepository<Employee, Long> {
}
