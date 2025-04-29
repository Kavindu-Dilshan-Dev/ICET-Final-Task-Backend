package com.kavindu.service;

import com.kavindu.dto.Employee;

import java.util.List;

public interface EmployeeService {
    void add(Employee employee);

    List<Employee> findAllEmployees();

    void updateEmployeeById(int id, Employee employee);

    void deleteEmployeeById(int id);
}
