package com.riyality.entity;

import org.springframework.boot.autoconfigure.cache.CacheType;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name="Departments")
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY.IDENTITY)
	private Long departmentID;
	
	@Column(nullable=false,unique=true)
	private String DepartmentName;
	
	  @OneToMany(mappedBy="department",cascade=CascadeType.ALL)
	  private List<Employee> employees;
	  
	  
	public Department() {
		
	}
	public Department(Long departmentId, String departmentName, List<Employee> employees) {
	    this.departmentID = departmentId;
	    this.DepartmentName = departmentName;
	    this.employees = employees;
	}
	}
	public Long getDepartmentId() {
		return departmentID;
		
	}
	
	public void setDepartmentId(Long departmentId) {
		this.departmentID=departmentId;
	}
	
	 public String getDepartmentName() {
	        return DepartmentName;
	    }
	
     public void setDepartmentName(String departmentName) {
    	 this.DepartmentName=departmentName;
     }
     
     public void setEmployees(List<Employee>Employees) {
    	    this.employees = employees;
     }
     @Override
     public String toString() {
         return "Department{" +"departmentId="+ departmentID +", departmentName='" + DepartmentName + '\'' + '}';
     }
     }

