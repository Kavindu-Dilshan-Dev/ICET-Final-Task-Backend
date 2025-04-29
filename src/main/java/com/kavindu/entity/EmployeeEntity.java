package com.kavindu.entity;

import com.kavindu.utils.Department;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 100)
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private Department department;
    private LocalDate createDate;
    private LocalDate lastUpdateDate;
}
