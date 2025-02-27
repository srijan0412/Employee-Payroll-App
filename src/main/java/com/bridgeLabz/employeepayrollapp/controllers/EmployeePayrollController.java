package com.bridgeLabz.employeepayrollapp.controllers;

import com.bridgeLabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgeLabz.employeepayrollapp.service.EmployeeServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.swing.text.html.parser.Entity;

import java.util.Map;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
    EmployeeServices employeeServices;

    public EmployeePayrollController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    // Get method to get a employee data
    @GetMapping(value = {"", "/", "get"})
    public ResponseEntity<String> getEmployeePayrollData(){
        return new ResponseEntity<String>("Get Call Successful", HttpStatus.OK);
    }

    // Get Method to get employee Data with id
    @GetMapping("/{id}")
    public ResponseEntity<String> getEmployeePayrollDataById(@PathVariable Long id){
        return new ResponseEntity<String>(("Get Call Successful with Id: " + id), HttpStatus.OK);
    }

    // Post Method to create a new employee payroll data
    @PostMapping("/create")
    public ResponseEntity<String> createNewEmployeePayrollData(@RequestBody EmployeePayrollDto employeePayrollDto) {
        return new ResponseEntity<String>("Post Call Successful" , HttpStatus.OK);
    }

    // Put Method to update employee payroll data
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDto employeePayrollDto, @PathVariable Long id) {
        return new ResponseEntity<String>("Put Call Successful with Id: " + id, HttpStatus.OK);
    }

    // Delete method to delete a payroll record from the DB
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable Long id) {
        return new ResponseEntity<String>("Delete Call Successful with Id: " + id, HttpStatus.OK);
    }
}
