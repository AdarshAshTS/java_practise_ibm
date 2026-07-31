package com.thymleafdemo.controllers;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.thymleafdemo.models.Employee;


public class EmployeeController{

    @GetMapping("/employees")
    public String employees(Model model) {

        List<Employee> employees = List.of(
                new Employee(101,"John","IT"),
                new Employee(102,"Alice","HR"),
                new Employee(103,"David","Finance")
        );

        model.addAttribute("employees", employees);

        return "employees";
    }
}