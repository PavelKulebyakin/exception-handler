package com.spring.practice.exceptionhandler.controller;

import com.spring.practice.exceptionhandler.entity.Employee;
import com.spring.practice.exceptionhandler.exception.NoSuchEmployeeException;
import com.spring.practice.exceptionhandler.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    private final EmployeeService employeeService;

    @Autowired
    public MyRESTController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = "
                    + id + " in Database");
        }
        return employee;
    }

    @PostMapping("/employee")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employee/{id}")
    private String deleteEmployee(@PathVariable Long id){
        Employee employee = employeeService.getEmployee(id);
        if(employee == null){
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + "in Database");
        }
        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted.";
    }
}
