package com.riyality.mapper;

import com.riyality.dto.employeeRequest;
import com.riyality.dto.employeeResponse;
import com.riyality.entity.Employee;

public class EmployeeMapper {
	 public static Employee toEntity(employeeRequest request) {

	        Employee employee = new Employee();

	        employee.setEmployeeCode(request.getEmployeeCode());
	        employee.setEmployeeName(request.getEmployeeName());
	        employee.setEmail(request.getEmail());
	        employee.setPhoneNumber(request.getPhoneNumber());
	        employee.setJoiningDate(request.getJoiningDate());

	        return employee;
	    }

	    public static employeeResponse toResponse(Employee employee) {

	        employeeResponse response = new employeeResponse();

	        response.setEmployeeId(employee.getEmployeeId());
	        response.setEmployeeCode(employee.getEmployeeCode());
	        response.setEmployeeName(employee.getEmployeeName());
	        response.setEmail(employee.getEmail());
	        response.setPhoneNumber(employee.getPhoneNumber());
	        response.setJoiningDate(employee.getJoiningDate());

	        return response;
	    }
}
