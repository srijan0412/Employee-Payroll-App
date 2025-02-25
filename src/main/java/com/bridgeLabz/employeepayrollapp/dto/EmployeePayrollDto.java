package com.bridgeLabz.employeepayrollapp.dto;

public class EmployeePayrollDto {
    public String name;
    public long salary;
    public EmployeePayrollDto(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "name: " + name + " salary: " + salary;
    }
}
