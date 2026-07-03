package com.riyality.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riyality.dto.EmployeeRequest;
import com.riyality.dto.EmployeeResponse;
import com.riyality.service.EmployeeService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController


@RequestMapping("/employee")
public class EmployeeController {

    
    private final EmployeeService service;

    @PostMapping
    public EmployeeResponse saveEmployee(@RequestBody EmployeeRequest employee) {
        return service.saveEmployee(employee);
    }

    
    @GetMapping("/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable UUID id) {
        return service.employeeGetById(id);
    }

    
    
    @GetMapping
    public List<EmployeeResponse> getAllEmployees() {
        return service.getAllEmployees();
    }

    
    @PutMapping("/{id}")
    public EmployeeResponse updateEmployee(
            @PathVariable UUID id,
            @RequestBody EmployeeRequest request) {

        return service.updateEmployee(id, request);
    }

    
    
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable UUID id) {

        service.deleteEmployee(id);

        return "Employee Deleted Successfully";
    }
}