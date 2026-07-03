package com.riyality.service;

import java.util.List;
import com.riyality.dto.UserRequest;
import com.riyality.dto.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest request);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);

    void deleteUser(Long id);
}