package com.spring.practice.exceptionhandler.service;


import com.spring.practice.exceptionhandler.entity.Employee;
import com.spring.practice.exceptionhandler.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DefaultEmployeeService implements EmployeeService{

    private final EmployeeRepository repository;

    @Autowired
    public DefaultEmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployee(Long id) {
        Optional<Employee> optional = repository.findById(id);
        if (optional.isPresent()) {                                           // Check if null
            return optional.get();
        }
        else throw new NoSuchElementException();                        // TODO
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        repository.save(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
