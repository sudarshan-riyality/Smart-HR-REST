package com.riyality.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private Long userId;
    private String username;
    private String role;
    private UUID employeeId;
}