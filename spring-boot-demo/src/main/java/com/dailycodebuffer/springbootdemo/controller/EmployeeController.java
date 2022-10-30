package com.dailycodebuffer.springbootdemo.controller;

import com.dailycodebuffer.springbootdemo.model.Employee;
import com.dailycodebuffer.springbootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService mEmployeeService;

    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return mEmployeeService.save(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return mEmployeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        return mEmployeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable String id) {
        return mEmployeeService.deleteEmployeeById(id);
    }
}
