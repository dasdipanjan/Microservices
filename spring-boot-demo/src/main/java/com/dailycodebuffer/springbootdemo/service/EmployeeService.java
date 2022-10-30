package com.dailycodebuffer.springbootdemo.service;

import com.dailycodebuffer.springbootdemo.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee save(Employee employee);
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(String id);
    public String deleteEmployeeById(String id);
}
