package com.riyality.mapper;

import com.riyality.dto.LeaveRequestResponse;
import com.riyality.entity.LeaveRequest;

public class LeaveRequestMapper {

    public static LeaveRequestResponse toResponse(
            LeaveRequest leave) {

        LeaveRequestResponse response =
                new LeaveRequestResponse();

        response.setLeaveRequestId(
                leave.getLeaveRequestId());

        response.setEmployeeId(
                leave.getEmployee().getEmployeeId());

        response.setEmployeeName(
                leave.getEmployee().getEmployeeName());

        response.setFromDate(
                leave.getFromDate());

        response.setToDate(
                leave.getToDate());

        response.setReason(
                leave.getReason());

        response.setStatus(
                leave.getStatus());

        return response;
    }
}