package com.riyality.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Leave_Request")
public class LeaveRequest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	private UUID leave_request_id;
	


}
