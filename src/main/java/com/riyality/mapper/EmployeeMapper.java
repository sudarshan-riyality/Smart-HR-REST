package com.riyality.mapper;

import com.riyality.dto.employeeRequest;
import com.riyality.dto.employeeResponse;
import com.riyality.entity.Employee;

public class EmployeeMapper {

    public static Employee toEntity(employeeRequest request) {

        Employee emp = new Employee();

        emp.setEmployeeCode(request.getEmployeeCode());
        emp.setEmployeeName(request.getEmployeeName());
        emp.setEmail(request.getEmail());
        emp.setPhoneNumber(request.getPhoneNumber());
        emp.setJoiningDate(request.getJoiningDate());

        return emp;
    }

    public static employeeResponse toResponse(Employee employee) {

        employeeResponse res = new employeeResponse();

        res.setEmployeeId(employee.getEmployeeId());
        res.setEmployeeCode(employee.getEmployeeCode());
        res.setEmployeeName(employee.getEmployeeName());
        res.setEmail(employee.getEmail());
        res.setPhoneNumber(employee.getPhoneNumber());
        res.setJoiningDate(employee.getJoiningDate());

        if (employee.getDepartment() != null) {
            res.setDepartmentId(employee.getDepartment().getDepartmentId());
        }

        return res;
    }
}