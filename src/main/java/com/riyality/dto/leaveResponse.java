package com.riyality.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.riyality.entity.LeaveStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class leaveResponse {

	  private Long leaveRequestId;
	  
	   private UUID employeeId;
		
	   private LocalDate fromDate;
	  
	    private LocalDate toDate;
	    
	    private String reason;
	    
	    private LeaveStatus status;
	    
	
}
