package com.bridgeLabz.employeepayrollapp.dto;

import com.bridgeLabz.employeepayrollapp.controllers.EmployeePayrollController;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@ToString
public class EmployeePayrollDto {
    public String name;
    public long salary;

    public EmployeePayrollDto(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }
}
