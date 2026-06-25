package com.riyality.service.impl;

import com.riyality.dto.leaveRequest;
import com.riyality.dto.leaveResponse;
import com.riyality.entity.Employee;
import com.riyality.entity.LeaveRequest;
import com.riyality.mapper.LeaveRequestMapper;
import com.riyality.repository.EmployeeRepository;
import com.riyality.repository.LeaveRequestRepository;
import com.riyality.service.LeaveRequestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

    private final LeaveRequestRepository leaveRepo;
    private final EmployeeRepository empRepo;

    public LeaveRequestServiceImpl(LeaveRequestRepository leaveRepo,
                                   EmployeeRepository empRepo) {
        this.leaveRepo = leaveRepo;
        this.empRepo = empRepo;
    }

    @Override
    public leaveResponse applyLeave(leaveRequest request) {

        Employee emp = empRepo.findById(request.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        LeaveRequest lr = LeaveRequestMapper.toEntity(request, emp);

        return LeaveRequestMapper.toResponse(leaveRepo.save(lr));
    }

    @Override
    public List<leaveResponse> getAllLeaves() {

        return leaveRepo.findAll()
                .stream()
                .map(LeaveRequestMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public leaveResponse getLeaveById(Long id) {

        LeaveRequest leave = leaveRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave Request not found"));

        return LeaveRequestMapper.toResponse(leave);
    }

    @Override
    public leaveResponse updateLeave(Long id, leaveRequest request) {

        LeaveRequest leave = leaveRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave Request not found"));

        Employee emp = empRepo.findById(request.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        leave.setFromDate(request.getFromDate());
        leave.setToDate(request.getToDate());
        leave.setReason(request.getReason());
        leave.setStatus(request.getStatus());
        leave.setEmployee(emp);

        return LeaveRequestMapper.toResponse(
                leaveRepo.save(leave));
    }

    @Override
    public void deleteLeave(Long id) {

        LeaveRequest leave = leaveRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave Request not found"));

        leaveRepo.delete(leave);
    }
}