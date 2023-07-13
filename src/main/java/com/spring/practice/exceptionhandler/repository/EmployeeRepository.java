package com.spring.practice.exceptionhandler.repository;

import com.spring.practice.exceptionhandler.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {
}
