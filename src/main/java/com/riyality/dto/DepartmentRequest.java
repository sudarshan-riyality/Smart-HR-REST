package com.riyality.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentRequest {
    
	
	
	 @NotBlank
	private String departmentName;
}
