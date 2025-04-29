package com.kavindu.repository;

import com.kavindu.dto.Employee;
import com.kavindu.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {

    EmployeeEntity searchEmployeeById(int id);
}
