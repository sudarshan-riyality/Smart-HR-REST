package com.riyality.service;

import java.util.List;
import java.util.UUID;

import com.riyality.dto.EmployeeRequest;
import com.riyality.dto.EmployeeResponse;

public interface EmployeeService {

    EmployeeResponse saveEmployee(EmployeeRequest request);

    EmployeeResponse employeeGetById(UUID id);

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse updateEmployee(UUID id, EmployeeRequest request);

    void deleteEmployee(UUID id);

}