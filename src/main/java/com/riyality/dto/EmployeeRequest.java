package com.riyality.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EmployeeRequest {

    private String employeeCode;
    
    @NotBlank
    private String employeeName;
    
    @Email
    private String email;
    
    @NotBlank
    private String phoneNumber;
    
    @NotNull
    private LocalDate joiningDate;

    private Long departmentId;



}