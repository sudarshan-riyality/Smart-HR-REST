package com.riyality.mapper;

import com.riyality.dto.DepartmentRequest;
import com.riyality.dto.DepartmentResponse;
import com.riyality.entity.Department;

public class DepartmentMapper {

    public static Department toEntity(DepartmentRequest request) {
        Department dept = new Department();
        dept.setDepartmentName(request.getDepartmentName());
        return dept;
    }

    public static DepartmentResponse toDto(Department dept) {
        DepartmentResponse response = new DepartmentResponse();
        response.setDepartmentId(dept.getDepartmentId());
        response.setDepartmentName(dept.getDepartmentName());
        return response;
    }
}