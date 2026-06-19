package com.riyality.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riyality.dto.employeeRequest;
import com.riyality.dto.employeeResponse;
import com.riyality.entity.Employee;
import com.riyality.mapper.EmployeeMapper;
import com.riyality.repository.EmployeeRepository;
import com.riyality.service.EmployeeService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    
    private final EmployeeRepository employeeRepository;

    //---------------------save Employee-----------------------------------------------
    
    
    @Override
    public employeeResponse saveEmployee(employeeRequest request) {

        Employee employee = EmployeeMapper.toEntity(request);

        employee.setDepartment(request.getDepartment());

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.toResponse(savedEmployee);
    }
    

    //-------------------Get By Id-------------------------------------------------------
    
    @Override
    public employeeResponse employeeGetById(UUID id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));

        return EmployeeMapper.toResponse(employee);
    }

    //------------------------Get All Employee------------------------------------------
    
    @Override
    public List<employeeResponse> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::toResponse)
                .collect(Collectors.toList());
    }

    
    //------------------------Update Employee--------------------------------------------
    
    @Override
    public employeeResponse updateEmployee(UUID id, employeeRequest request) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));

        employee.setEmployeeCode(request.getEmployeeCode());
        employee.setEmployeeName(request.getEmployeeName());
        employee.setEmail(request.getEmail());
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setJoiningDate(request.getJoiningDate());
        employee.setDepartment(request.getDepartment());

        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.toResponse(updatedEmployee);
    }

    
    //--------------------------Delete Employee------------------------------------------
    
    @Override
    public void deleteEmployee(UUID id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));

        employeeRepository.delete(employee);
    }
}