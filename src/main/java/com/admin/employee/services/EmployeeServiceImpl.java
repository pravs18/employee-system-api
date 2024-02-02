package com.admin.employee.services;

import com.admin.employee.entity.EmployeeEntity;
import com.admin.employee.model.Employee;
import com.admin.employee.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;



@Service

public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    @Override

    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity=new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }


    public  List <Employee> getAllEmployees(){
        List <EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> new Employee(employeeEntity.getId(),
                        employeeEntity.getTitle(),
                        employeeEntity.getDescription(),
                        employeeEntity.getDue_date(),
                        employeeEntity.getCompleted()))
                .collect(Collectors.toList());
    }
    @Override
    public boolean deleteEmployee(Long id){
        EmployeeEntity employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return true;

    }

    @Override
    public Employee getEmployeeById(Long id) {
        EmployeeEntity employeeEntity= employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity,employee);
        return ResponseEntity.ok(employee);
    }
    @Override
    public Employee updateEmployee(Long id, Employee employee){
        EmployeeEntity employeeEntity
                = employeeRepository.findById(id).get();
        employeeEntity.setTitle(employee.getTitle());
        employeeEntity.setDescription(employee.getDescription());
        employeeEntity.setDue_date(employee.getDue_date());
        employeeEntity.setCompleted(employee.getCompleted());
        employeeRepository.save(employeeEntity);
        return employee;
    }
}
