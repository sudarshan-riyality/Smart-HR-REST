package com.riyality.service;

import java.util.List;

import com.riyality.dto.leaveRequest;
import com.riyality.dto.leaveResponse;

public interface LeaveRequestService {

   
    leaveResponse applyLeave(leaveRequest request);


    List<leaveResponse> getAllLeaves();

   
    leaveResponse getLeaveById(Long id);

  
    leaveResponse updateLeave(Long id, leaveRequest request);

  
    void deleteLeave(Long id);
}