package com.riyality.entity;



import java.time.LocalDate;



import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Leave_Request")
public class LeaveRequest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long leaveRequestId;
	
    private LocalDate fromDate;
    private LocalDate toDate;
    
    private String reason;
    
    @Enumerated(EnumType.STRING)   
    private LeaveStatus status;
    
    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;
    
    public LeaveRequest() {
    	
    }
    
    

	public LeaveRequest(Long leaveRequestId, LocalDate fromDate, LocalDate toDate, String reason, LeaveStatus status,
			Employee employee) {
		super();
		this.leaveRequestId = leaveRequestId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.reason = reason;
		this.status = status;
		this.employee = employee;
	}



	public Long getLeaveRequestId() {
		return leaveRequestId;
	}

	public void setLeaveRequestId(Long leaveRequestId) {
		this.leaveRequestId = leaveRequestId;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LeaveStatus getStatus() {
		return status;
	}

	public void setStatus(LeaveStatus status) {
		this.status = status;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

    
    
}
