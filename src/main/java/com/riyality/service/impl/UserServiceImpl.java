package com.riyality.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.riyality.dto.UserRequest;
import com.riyality.dto.UserResponse;
import com.riyality.entity.Employee;
import com.riyality.entity.Role;
import com.riyality.entity.User;
import com.riyality.repository.EmployeeRepository;
import com.riyality.repository.UserRepository;
import com.riyality.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;

    public UserServiceImpl(UserRepository userRepository,
                           EmployeeRepository employeeRepository) {
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserResponse createUser(UserRequest request) {

        if (request == null) {
            throw new RuntimeException("Request cannot be null");
        }

        if (request.getEmployeeId() == null) {
            throw new RuntimeException("Employee ID cannot be null");
        }

        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        if (request.getRole() == null || request.getRole().isBlank()) {
            throw new RuntimeException("Role is required");
        }

        Role role;
        try {
            role = Role.valueOf(request.getRole().toUpperCase());
        } catch (Exception e) {
            throw new RuntimeException("Invalid role: " + request.getRole());
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole(role);
        user.setEmployee(employee); 

        User savedUser = userRepository.save(user);

        return mapToResponse(savedUser);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(Long id) {

        if (id == null) {
            throw new RuntimeException("User ID cannot be null");
        }

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return mapToResponse(user);
    }

    @Override
    public void deleteUser(Long id) {

        if (id == null) {
            throw new RuntimeException("User ID cannot be null");
        }

        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }

        userRepository.deleteById(id);
    }

    private UserResponse mapToResponse(User user) {

        UserResponse response = new UserResponse();
        response.setUserId(user.getUserId());
        response.setUsername(user.getUsername());

        if (user.getRole() != null) {
            response.setRole(user.getRole().name());
        }

       
        if (user.getEmployee() != null) {
            response.setEmployeeId(user.getEmployee().getEmployeeId());
        } else {
            response.setEmployeeId(null);
        }

        return response;
    }
}