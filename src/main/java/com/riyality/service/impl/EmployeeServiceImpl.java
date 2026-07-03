package com.riyality.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.riyality.dto.EmployeeRequest;
import com.riyality.dto.EmployeeResponse;
import com.riyality.entity.Department;
import com.riyality.entity.Employee;
import com.riyality.mapper.EmployeeMapper;
import com.riyality.repository.DepartmentRepository;
import com.riyality.repository.EmployeeRepository;
import com.riyality.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public EmployeeResponse saveEmployee(EmployeeRequest request) {

        Employee employee = EmployeeMapper.toEntity(request);

        Department dept = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        employee.setDepartment(dept);

        return EmployeeMapper.toResponse(employeeRepository.save(employee));
    }

    @Override
    public EmployeeResponse employeeGetById(UUID id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));

        return EmployeeMapper.toResponse(employee);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse updateEmployee(UUID id, EmployeeRequest request) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));

        employee.setEmployeeCode(request.getEmployeeCode());
        employee.setEmployeeName(request.getEmployeeName());
        employee.setEmail(request.getEmail());
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setJoiningDate(request.getJoiningDate());

        Department dept = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        employee.setDepartment(dept);

        return EmployeeMapper.toResponse(employeeRepository.save(employee));
    }

    @Override
    public void deleteEmployee(UUID id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));

        employeeRepository.delete(employee);
    }
}