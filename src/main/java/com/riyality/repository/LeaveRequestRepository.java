package com.riyality.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riyality.entity.LeaveRequest;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

	   List<LeaveRequest> findByEmployeeEmployeeId(UUID employeeId);
	
}