package com.riyality.service;

import java.util.List;
import java.util.UUID;

import com.riyality.dto.LeaveRequestRequest;
import com.riyality.dto.LeaveRequestResponse;

public interface LeaveRequestService {

    LeaveRequestResponse applyLeave(
            LeaveRequestRequest request);

    LeaveRequestResponse approveLeave(
            Long leaveId);

    LeaveRequestResponse rejectLeave(
            Long leaveId);

    List<LeaveRequestResponse> getEmployeeLeaves(
            UUID employeeId);

}