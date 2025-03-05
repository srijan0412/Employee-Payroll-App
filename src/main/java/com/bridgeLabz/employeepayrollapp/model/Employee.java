package com.bridgeLabz.employeepayrollapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Za-z ]{3,50}$", message = "Name must contain only letters and be 3-50 characters long")
    private String name;
    @Column(nullable = false)
    private long salary;

    Employee() {}

    public Employee(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }
    public long getId() {
        return id;
    }
    public long getSalary() {
        return salary;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSalary(long salary) {
        this.salary = salary;
    }
}
