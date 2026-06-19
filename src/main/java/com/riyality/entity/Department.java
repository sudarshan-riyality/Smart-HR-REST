package com.riyality.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Department")
public class Department {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long Department;

private String departmentName;

@OneToMany(mappedBy="department")
private List<Employee> Employees;

public Department() {
	
}


public Department(Long department, String departmentName, List<Employee> employees) {
	super();
	Department = department;
	this.departmentName = departmentName;
	Employees = employees;
}

public Long getDepartment() {
	return Department;
}

public void setDepartment(Long department) {
	Department = department;
}

public String getDepartmentName() {
	return departmentName;
}

public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}

public List<Employee> getEmployees() {
	return Employees;
}

public void setEmployees(List<Employee> employees) {
	Employees = employees;
}


}
