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

import com.riyality.dto.employeeRequest;
import com.riyality.dto.employeeResponse;
import com.riyality.service.EmployeeService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController

//------------------------------------------Save Employee-------------------------------------------------

@RequestMapping("/employee")
public class EmployeeController {

    
    private final EmployeeService service;

    @PostMapping
    public employeeResponse saveEmployee(@RequestBody employeeRequest employee) {
        return service.saveEmployee(employee);
    }

//-------------------------------------Get By Id -----------------------------------------------------------
    
    @GetMapping("/{id}")
    public employeeResponse getEmployeeById(@PathVariable UUID id) {
        return service.employeeGetById(id);
    }

    
//---------------------------------Get All Employee---------------------------------------------------------    
    
    @GetMapping
    public List<employeeResponse> getAllEmployees() {
        return service.getAllEmployees();
    }

//--------------------------------Update Employee-----------------------------------------------------------    
    
    @PutMapping("/{id}")
    public employeeResponse updateEmployee(
            @PathVariable UUID id,
            @RequestBody employeeRequest request) {

        return service.updateEmployee(id, request);
    }

//-------------------------------------Delete Employee------------------------------------------------------
    
    
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable UUID id) {

        service.deleteEmployee(id);

        return "Employee Deleted Successfully";
    }
}