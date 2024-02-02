package com.admin.employee.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name="employees")

public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String Title;
    private String Description;
    private LocalDate Due_date;
    private String Completed;
}
