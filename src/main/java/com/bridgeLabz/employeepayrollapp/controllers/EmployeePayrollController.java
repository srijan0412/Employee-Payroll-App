package com.bridgeLabz.employeepayrollapp.controllers;

import com.bridgeLabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgeLabz.employeepayrollapp.model.Employee;
import com.bridgeLabz.employeepayrollapp.service.EmployeeServices;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.swing.text.html.parser.Entity;

import java.util.Map;
import java.util.Optional;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
    EmployeeServices employeeServices;

    public EmployeePayrollController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    // Get method to get a employee data
    @GetMapping(value = {"", "/", "get"})
    public ResponseEntity<List<Employee>> getEmployeePayrollData(){
        log.info("GET Request - Retrieve all the Employee Payrolls");
        return new ResponseEntity<List<Employee>>(employeeServices.getAllEmployeeRecords(), HttpStatus.OK);
    }

    // Get Method to get employee Data with id
    @GetMapping("/{id}")
    public ResponseEntity<EmployeePayrollDto> getEmployeePayrollDataById(@PathVariable Long id){
        log.info("GET Request - Retrieve employee details by Employee ID.");
        return new ResponseEntity<EmployeePayrollDto>(employeeServices.retrieveEmployeeDataById(id), HttpStatus.OK);
    }

    // Post Method to create a new employee payroll data
    @PostMapping("/create")
    public ResponseEntity<String> createNewEmployeePayrollData(@Valid @RequestBody Employee employee) {
        log.info("POST Request - Add a new Employee Record.");
        return new ResponseEntity<String>(employeeServices.addANewEmployee(employee) , HttpStatus.OK);
    }

    // Put Method to update employee payroll data
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody Employee employee, @PathVariable Long id) {
        log.info("PUT Request - Update an Employee Record.");
        return new ResponseEntity<String>(employeeServices.updateEmployee(employee, id), HttpStatus.OK);
    }

    // Delete method to delete a payroll record from the DB
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable Long id) {
        log.info("DELETE Request - Delete a Employee Record.");
        return new ResponseEntity<String>(employeeServices.deleteEmployee(id) + id, HttpStatus.OK);
    }
}
