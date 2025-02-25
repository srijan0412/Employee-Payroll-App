package com.bridgeLabz.employeepayrollapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.swing.text.html.parser.Entity;

import java.util.Map;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
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
    public ResponseEntity<Map<String, String>> createNewEmployeePayrollData(@RequestBody Map<String, String > request) {
        return new ResponseEntity<Map<String, String>>(request , HttpStatus.OK);
    }

    // Put Method to update employee payroll data
    @PutMapping("/update")
    public ResponseEntity<Map<String, String>> updateEmployeePayrollData(@RequestBody Map<String, String> request) {
        return new ResponseEntity<Map<String, String>>(request, HttpStatus.OK);
    }

    // Delete method to delete a payroll record from the DB
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable Long id) {
        return new ResponseEntity<String>("Delete Call Successful with Id" + id, HttpStatus.OK);
    }
}
