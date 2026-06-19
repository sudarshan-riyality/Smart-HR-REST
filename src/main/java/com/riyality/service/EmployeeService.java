package com.riyality.service;

import java.util.List;
import java.util.UUID;

import com.riyality.dto.employeeRequest;
import com.riyality.dto.employeeResponse;

public interface EmployeeService {

    employeeResponse saveEmployee(employeeRequest request);

    employeeResponse employeeGetById(UUID id);

    List<employeeResponse> getAllEmployees();

    employeeResponse updateEmployee(UUID id, employeeRequest request);

    void deleteEmployee(UUID id);

}