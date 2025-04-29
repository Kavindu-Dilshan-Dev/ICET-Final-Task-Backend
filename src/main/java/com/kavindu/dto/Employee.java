package com.kavindu.dto;

import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

    private Integer id;
    private String name;
    private String email;
    private String department;
    private LocalDate createDate;
    private LocalDate lastUpdateDate;
}
