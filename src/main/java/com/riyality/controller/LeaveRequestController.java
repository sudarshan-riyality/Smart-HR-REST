package com.riyality.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.riyality.dto.leaveRequest;
import com.riyality.dto.leaveResponse;
import com.riyality.service.LeaveRequestService;

@RestController
@RequestMapping("/leave")
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;

    public LeaveRequestController(LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    // Add Leave
    @PostMapping
    public ResponseEntity<leaveResponse> applyLeave(
            @RequestBody leaveRequest request) {

        return ResponseEntity.ok(
                leaveRequestService.applyLeave(request));
    }

    // View All Leaves
    @GetMapping
    public ResponseEntity<List<leaveResponse>> getAllLeaves() {

        return ResponseEntity.ok(
                leaveRequestService.getAllLeaves());
    }

    // View Leave By Id
    @GetMapping("/{id}")
    public ResponseEntity<leaveResponse> getLeaveById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                leaveRequestService.getLeaveById(id));
    }

    // Update Leave
    @PutMapping("/{id}")
    public ResponseEntity<leaveResponse> updateLeave(
            @PathVariable Long id,
            @RequestBody leaveRequest request) {

        return ResponseEntity.ok(
                leaveRequestService.updateLeave(id, request));
    }

    // Delete Leave
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLeave(
            @PathVariable Long id) {

        leaveRequestService.deleteLeave(id);

        return ResponseEntity.ok("Leave Deleted Successfully");
    }
}