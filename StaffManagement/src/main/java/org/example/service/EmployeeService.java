package org.example.service;


import org.example.model.entity.EmployeeEntity;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity createEmployee(EmployeeEntity emp){
        return employeeRepository.save(emp);
    }

    public EmployeeEntity updateEmployee(int id,EmployeeEntity emp) throws Exception{
        Optional<EmployeeEntity> empId = employeeRepository.findById(id);
        if (empId == null) {
            throw new Exception("Employee not found with ID: " + id);
        }
            emp.setAge(emp.getAge());
            emp.setName(emp.getName());

        return employeeRepository.save(emp);
    }
}