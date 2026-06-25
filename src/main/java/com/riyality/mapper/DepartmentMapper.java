package com.riyality.mapper;

import com.riyality.dto.departmentRequest;
import com.riyality.dto.departmentResponse;
import com.riyality.entity.Department;

public class DepartmentMapper {

    public static Department toEntity(departmentRequest request) {
        Department dept = new Department();
        dept.setDepartmentName(request.getDepartmentName());
        return dept;
    }

    public static departmentResponse toDto(Department dept) {
        departmentResponse response = new departmentResponse();
        response.setDepartmentId(dept.getDepartmentId());
        response.setDepartmentName(dept.getDepartmentName());
        return response;
    }
}