package com.riyality.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.riyality.entity.LeaveStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaveRequestResponse {

	  private Long leaveRequestId;
	  
	   private UUID employeeId;
	   private String employeeName;
		
	   private LocalDate fromDate;
	  
	    private LocalDate toDate;
	    
	    private String reason;
	    
	    private LeaveStatus status;
	    
	
}
