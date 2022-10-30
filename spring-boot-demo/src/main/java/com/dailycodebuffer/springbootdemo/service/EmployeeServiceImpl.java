package com.dailycodebuffer.springbootdemo.service;

import com.dailycodebuffer.springbootdemo.exception.EmployeeNotFoundException;
import com.dailycodebuffer.springbootdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> mEmployeeList;

    public EmployeeServiceImpl() {
        this.mEmployeeList = new ArrayList<>();
    }

    @Override
    public Employee save(Employee employee) {
        if (employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()) {
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        mEmployeeList.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return mEmployeeList;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return mEmployeeList
                .stream()
                .filter(employee -> employee.getEmployeeId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException(" " +
                        "Employee not found with Id: "+id));
    }

    @Override
    public String deleteEmployeeById(String id) {
        Employee employee
                = mEmployeeList
                .stream()
                .filter(e -> e.getEmployeeId().equalsIgnoreCase(id))
                .findFirst()
                .get();
        mEmployeeList.remove(employee);
        return "Employee has been removed from list with ID: = "+employee.getEmployeeId();
    }
}
