package com.kavindu.service.impl;

import com.kavindu.dto.Employee;
import com.kavindu.entity.EmployeeEntity;
import com.kavindu.repository.EmployeeRepository;
import com.kavindu.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final ModelMapper mapper;

    @Override
    public void add(Employee employee) {
        repository.save(mapper.map(employee, EmployeeEntity.class));
    }

    @Override
    public List<Employee> findAllEmployees() {
       List<EmployeeEntity> employeeEntities = repository.findAll();
       List<Employee> employees = new ArrayList<>();

       employeeEntities.forEach(employee -> {
           employees.add(mapper.map(employee, Employee.class));
       });

       return employees;
    }

    @Override
    public void updateEmployeeById(int id, Employee employee) {
        EmployeeEntity getEmployee = repository.searchEmployeeById(id);
        if (getEmployee != null) {
            repository.save(mapper.map(employee, EmployeeEntity.class));
        }
    }

    @Override
    public void deleteEmployeeById(int id) {
        repository.deleteById(id);
    }
}
