package com.bridgeLabz.employeepayrollapp.service;

import com.bridgeLabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgeLabz.employeepayrollapp.exception.EmployeeNotFoundException;
import com.bridgeLabz.employeepayrollapp.model.Employee;
import com.bridgeLabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {
    private final EmployeeRepository employeeRepository;

    public EmployeeServices(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Method to retrieve data from the repository with the help of id
    public EmployeePayrollDto retrieveEmployeeDataById(Long id) {
        return employeeRepository.findById(id)
                .map(employee -> new EmployeePayrollDto(employee.getName(), employee.getSalary()))
                    .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));
    }

    // Get Method to get all employee records
    public List<Employee> getAllEmployeeRecords() {
        return employeeRepository.findAll();
    }

    // Method to Add a new Employee
    public String addANewEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return "Saved with id: " + savedEmployee.getId();
    }

    // Method to update an Employee's data
    public String updateEmployee(Employee employee, Long id) {
        Optional<Employee> newEmployee = employeeRepository.findById(id).map(employee1 -> {
            employee1.setName(employee.getName());
            employee1.setSalary(employee.getSalary());
            return employeeRepository.save(employee1);
        });
        return "Employee Record Updated Successfully.";
    }

    // Method to delete an employee's record
    public String deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return "Employee Record Deleted Successfully.";
    }
}
