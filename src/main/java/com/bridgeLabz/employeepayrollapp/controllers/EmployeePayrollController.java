package com.bridgeLabz.employeepayrollapp.controllers;

import com.bridgeLabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgeLabz.employeepayrollapp.model.Employee;
import com.bridgeLabz.employeepayrollapp.service.EmployeeServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.swing.text.html.parser.Entity;

import java.util.Map;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
    EmployeeServices employeeServices;

    public EmployeePayrollController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    // Get method to get a employee data
    @GetMapping(value = {"", "/", "get"})
    public ResponseEntity<List<Employee>> getEmployeePayrollData(){
        return new ResponseEntity<List<Employee>>(employeeServices.getAllEmployeeRecords(), HttpStatus.OK);
    }

    // Get Method to get employee Data with id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<EmployeePayrollDto>> getEmployeePayrollDataById(@PathVariable Long id){
        return new ResponseEntity<Optional<EmployeePayrollDto>>(employeeServices.retrieveEmployeeDataById(id), HttpStatus.OK);
    }

    // Post Method to create a new employee payroll data
    @PostMapping("/create")
    public ResponseEntity<String> createNewEmployeePayrollData(@RequestBody Employee employee) {
        return new ResponseEntity<String>(employeeServices.addANewEmployee(employee) , HttpStatus.OK);
    }

    // Put Method to update employee payroll data
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody Employee employee, @PathVariable Long id) {
        return new ResponseEntity<String>(employeeServices.updateEmployee(employee, id), HttpStatus.OK);
    }

    // Delete method to delete a payroll record from the DB
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable Long id) {
        return new ResponseEntity<String>(employeeServices.deleteEmployee(id) + id, HttpStatus.OK);
    }
}
