package com.riyality.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

 @Id
 @GeneratedValue(strategy=GenerationType.UUID)
 private UUID employeeId;
 
 @Column(name="employee_code")
 private String employeeCode;
 
 @Column(name="employee_name")
 private String employeeName;
 
 @Column(name="email")
 private String email;
 
 @Column(name="phone_number")
 private String phoneNumber;
 
 @Column(name="joining_date")
 private LocalDate joiningDate;
 
@ManyToOne
@JoinColumn(name="department_id")
private Department department;

public Employee() {
}
public Employee(UUID employeeId, String employeeCode, String employeeName, String email, String phoneNumber,
		LocalDate joiningDate, Department department) {
	super();
	this.employeeId = employeeId;
	this.employeeCode = employeeCode;
	this.employeeName = employeeName;
	this.email = email;
	this.phoneNumber = phoneNumber;
	this.joiningDate = joiningDate;
	this.department = department;
}

public UUID getEmployeeId() {
	return employeeId;
}

public void setEmployeeId(UUID employeeId) {
	this.employeeId = employeeId;
}

public String getEmployeeCode() {
	return employeeCode;
}

public void setEmployeeCode(String employeeCode) {
	this.employeeCode = employeeCode;
}

public String getEmployeeName() {
	return employeeName;
}

public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public LocalDate getJoiningDate() {
	return joiningDate;
}

public void setJoiningDate(LocalDate joiningDate) {
	this.joiningDate = joiningDate;
}

public Department getDepartment() {
    return department;
}

public void setDepartment(Department department) {
    this.department = department;

}
 
 
}
