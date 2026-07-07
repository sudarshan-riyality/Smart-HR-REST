package com.riyality.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riyality.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

}
