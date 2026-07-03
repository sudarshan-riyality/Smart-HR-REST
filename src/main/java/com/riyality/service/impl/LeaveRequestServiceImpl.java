package com.riyality.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.riyality.dto.LeaveRequestRequest;
import com.riyality.dto.LeaveRequestResponse;
import com.riyality.entity.Employee;
import com.riyality.entity.LeaveRequest;
import com.riyality.entity.LeaveStatus;
import com.riyality.mapper.LeaveRequestMapper;
import com.riyality.repository.EmployeeRepository;
import com.riyality.repository.LeaveRequestRepository;
import com.riyality.service.LeaveRequestService;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

    private final LeaveRequestRepository leaveRepository;
    private final EmployeeRepository employeeRepository;

    public LeaveRequestServiceImpl(
            LeaveRequestRepository leaveRepository,
            EmployeeRepository employeeRepository) {

        this.leaveRepository = leaveRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public LeaveRequestResponse applyLeave(
            LeaveRequestRequest request) {

        Employee employee =
                employeeRepository.findById(
                        request.getEmployeeId())
                .orElseThrow();

        LeaveRequest leave =
                new LeaveRequest();

        leave.setEmployee(employee);
        leave.setFromDate(request.getFromDate());
        leave.setToDate(request.getToDate());
        leave.setReason(request.getReason());

        leave.setStatus(
                LeaveStatus.PENDING);

        return LeaveRequestMapper.toResponse(
                leaveRepository.save(leave));
    }

    @Override
    public LeaveRequestResponse approveLeave(
            Long leaveId) {

        LeaveRequest leave =
                leaveRepository.findById(leaveId)
                .orElseThrow();

        leave.setStatus(
                LeaveStatus.APPROVED);

        return LeaveRequestMapper.toResponse(
                leaveRepository.save(leave));
    }

    @Override
    public LeaveRequestResponse rejectLeave(
           Long leaveId) {

        LeaveRequest leave =
                leaveRepository.findById(leaveId)
                .orElseThrow();

        leave.setStatus(
                LeaveStatus.REJECTED);

        return LeaveRequestMapper.toResponse(
                leaveRepository.save(leave));
    }

    @Override
    public List<LeaveRequestResponse>
    getEmployeeLeaves(UUID employeeId) {
        return leaveRepository
                .findByEmployeeEmployeeId(employeeId)
                .stream()
                .map(LeaveRequestMapper::toResponse)
                .toList();
    }
}