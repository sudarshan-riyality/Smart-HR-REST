package com.riyality.mapper;

import com.riyality.dto.UserRequest;
import com.riyality.dto.UserResponse;
import com.riyality.entity.Employee;
import com.riyality.entity.User;

public class UserMapper {

	public static User toEntity(UserRequest request, Employee employee) {

	    User user = new User();

	    user.setUsername(request.getUsername());
	    user.setPassword(request.getPassword());
	    user.setRole(request.getRole());

	    user.setEmployee(employee); // 

	    return user;
	}


    public static UserResponse toResponse(User user) {

        UserResponse response = new UserResponse();

        response.setUserId(user.getUserId());
        response.setUsername(user.getUsername());

        if (user.getRole() != null) {
            response.setRole(user.getRole().name());
        }

        if (user.getEmployee() != null) {
            response.setEmployeeId(user.getEmployee().getEmployeeId());
        
        }

        return response;
    }
}
