package com.riyality.service;

import java.util.List;
import com.riyality.dto.DepartmentRequest;
import com.riyality.dto.DepartmentResponse;

public interface DepartmentService {

    DepartmentResponse saveDepartment(DepartmentRequest request);

    DepartmentResponse getDepartmentById(Long id);

    List<DepartmentResponse> getAllDepartments();

    DepartmentResponse updateDepartment(Long id, DepartmentRequest request);

    void deleteDepartment(Long id);
}