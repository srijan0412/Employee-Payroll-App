package com.bridgeLabz.employeepayrollapp.service;

import com.bridgeLabz.employeepayrollapp.model.Employee;
import com.bridgeLabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServices {
    private EmployeeRepository employeeRepository;

    public EmployeeServices(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Optional<Employee> retrieveEmployeeDataById(Long id) {
        return employeeRepository.findById(id);
    }
}
