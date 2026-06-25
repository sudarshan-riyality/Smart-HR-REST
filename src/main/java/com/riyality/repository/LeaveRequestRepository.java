package com.riyality.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riyality.entity.LeaveRequest;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

}