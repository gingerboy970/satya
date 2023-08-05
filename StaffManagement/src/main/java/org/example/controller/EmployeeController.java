package org.example.controller;

import org.example.model.entity.EmployeeEntity;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity emp) {
        try {
            EmployeeEntity createdEmp = employeeService.createEmployee(emp);
            return createdEmp;
        } catch (DataAccessException ex) {
            System.err.println("Error occurred while creating the employee: " + ex.getMessage());
            throw new RuntimeException("Failed to create the employee. Please try again later.");
        }
        }


     @PutMapping("{id}")
    public EmployeeEntity updateEmployee(@PathVariable int id, @RequestBody EmployeeEntity emp ) throws Exception {
        return employeeService.updateEmployee(id,emp);
    }


}