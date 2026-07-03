package com.riyality.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.riyality.dto.DepartmentRequest;
import com.riyality.dto.DepartmentResponse;
import com.riyality.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DepartmentResponse> create(@RequestBody DepartmentRequest request) {
        return ResponseEntity.ok(service.saveDepartment(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getDepartmentById(id));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAll() {
        return ResponseEntity.ok(service.getAllDepartments());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponse> update(
            @PathVariable Long id,
            @RequestBody DepartmentRequest request) {
        return ResponseEntity.ok(service.updateDepartment(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteDepartment(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}