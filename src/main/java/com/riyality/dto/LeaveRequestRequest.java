package com.riyality.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.riyality.entity.Employee;
import com.riyality.entity.LeaveStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class LeaveRequestRequest {
	  
	   @NotNull
	   private UUID employeeId;
	
	   @NotNull
	  private LocalDate fromDate;
	  
	   @NotNull
	    private LocalDate toDate;
	    
	   @NotBlank
	    private String reason;
	    


	
	    
	
}
