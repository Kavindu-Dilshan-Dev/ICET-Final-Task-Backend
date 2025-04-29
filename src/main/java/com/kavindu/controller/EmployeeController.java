package com.kavindu.controller;

import com.kavindu.dto.Employee;
import com.kavindu.service.EmployeeService;
import com.kavindu.validation.Validations;
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
    private final Validations validations;

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee) {
        if (validations.isValidEmail(employee.getEmail())){
            if(validations.isValidName(employee.getName())) {
                service.add(employee);
            }
        }

    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return service.findAllEmployees();
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody Employee employee) {
        service.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteEmployee(@PathVariable int id) {
        service.deleteEmployeeById(id);
    }
}
