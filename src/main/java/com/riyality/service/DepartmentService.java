package com.riyality.service;

import java.util.List;
import com.riyality.dto.departmentRequest;
import com.riyality.dto.departmentResponse;

public interface DepartmentService {

    departmentResponse saveDepartment(departmentRequest request);

    departmentResponse getDepartmentById(Long id);

    List<departmentResponse> getAllDepartments();

    departmentResponse updateDepartment(Long id, departmentRequest request);

    void deleteDepartment(Long id);
}