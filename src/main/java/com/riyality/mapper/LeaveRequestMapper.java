package com.riyality.mapper;

import com.riyality.dto.leaveRequest;
import com.riyality.dto.leaveResponse;
import com.riyality.entity.Employee;
import com.riyality.entity.LeaveRequest;

public class LeaveRequestMapper {

    public static LeaveRequest toEntity(leaveRequest request, Employee employee) {

        LeaveRequest lr = new LeaveRequest();

        lr.setFromDate(request.getFromDate());
        lr.setToDate(request.getToDate());
        lr.setReason(request.getReason());
        lr.setStatus(request.getStatus());

        lr.setEmployee(employee);

        return lr;
    }

 

        public static leaveResponse toResponse(LeaveRequest lr) {

            leaveResponse res = new leaveResponse();

            res.setLeaveRequestId(lr.getLeaveRequestId());

            if (lr.getEmployee() != null) {
                res.setEmployeeId(lr.getEmployee().getEmployeeId());
            }

            res.setFromDate(lr.getFromDate());
            res.setToDate(lr.getToDate());
            res.setReason(lr.getReason());
            res.setStatus(lr.getStatus());

            return res;
        }
    }
