package com.riyality.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.riyality.dto.LeaveRequestRequest;
import com.riyality.dto.LeaveRequestResponse;
import com.riyality.service.LeaveRequestService;

@RestController
@RequestMapping("/api/leaves")
public class LeaveRequestController {

    private final LeaveRequestService leaveService;

    public LeaveRequestController(
            LeaveRequestService leaveService) {

        this.leaveService = leaveService;
    }

    @PostMapping("/apply")
    public LeaveRequestResponse applyLeave(
            @RequestBody LeaveRequestRequest request) {

        return leaveService.applyLeave(request);
    }
    @PutMapping("/{id}/approve")
    public LeaveRequestResponse approveLeave(@PathVariable Long id) {
        return leaveService.approveLeave(id);
    }

    @PutMapping("/{id}/reject")
    public LeaveRequestResponse rejectLeave(@PathVariable Long id) {
        return leaveService.rejectLeave(id);
    }

    @GetMapping("/employee/{employeeId}")
    public List<LeaveRequestResponse>
    getEmployeeLeaves(
            @PathVariable UUID employeeId) {

        return leaveService
                .getEmployeeLeaves(employeeId);
    }
}