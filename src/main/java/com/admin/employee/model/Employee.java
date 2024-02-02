package com.admin.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
    private long id;
    private String Title;
    private String Description;
    private String Completed;
    private LocalDate Due_date;

    public Employee(long id, String title, String description, LocalDate dueDate, String completed) {
    }
}
