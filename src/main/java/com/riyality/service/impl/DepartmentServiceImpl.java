package com.riyality.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.riyality.dto.departmentRequest;
import com.riyality.dto.departmentResponse;
import com.riyality.entity.Department;
import com.riyality.mapper.DepartmentMapper;
import com.riyality.repository.DepartmentRepository;
import com.riyality.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public departmentResponse saveDepartment(departmentRequest request) {

        Department dept = DepartmentMapper.toEntity(request);

        Department saved = repository.save(dept);

        return DepartmentMapper.toDto(saved);
    }

    @Override
    public departmentResponse getDepartmentById(Long id) {

        Department dept = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        return DepartmentMapper.toDto(dept);
    }

    @Override
    public List<departmentResponse> getAllDepartments() {

        return repository.findAll()
                .stream()
                .map(DepartmentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public departmentResponse updateDepartment(Long id, departmentRequest request) {

        Department dept = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        dept.setDepartmentName(request.getDepartmentName());

        return DepartmentMapper.toDto(repository.save(dept));
    }

    @Override
    public void deleteDepartment(Long id) {
        repository.deleteById(id);
    }
}