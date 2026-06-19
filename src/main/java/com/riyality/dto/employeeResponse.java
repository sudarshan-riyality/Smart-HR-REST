package com.riyality.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.riyality.entity.Department;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class employeeResponse {

    private UUID employeeId;

    private String employeeCode;

    private String employeeName;

    private String email;

    private String phoneNumber;

    private LocalDate joiningDate;

    private Department department;
}