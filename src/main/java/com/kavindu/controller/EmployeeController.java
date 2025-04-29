package com.kavindu.controller;

import com.kavindu.dto.Employee;
import com.kavindu.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee) {
        service.add(employee);
    }

    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return service.findAllEmployees();
    }

    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        service.updateEmployeeById(id,employee);
    }

    @DeleteMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteEmployee(@PathVariable int id) {
        service.deleteEmployeeById(id);
    }
}
