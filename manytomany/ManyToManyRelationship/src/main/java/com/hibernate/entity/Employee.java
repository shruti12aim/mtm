package com.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="EMPLOYEE")
public class Employee
{
    @Id
    @Column(name="EMP_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int empId;
    
    @Column(name="EMP_NAME", nullable = false)
    private String empName;
    
    @Column(unique=true, nullable=false, length=30)
    private String email;
    
    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinTable(name = "employee_project",
                        joinColumns =  @JoinColumn(name = "emp_id"), 
                        inverseJoinColumns =  @JoinColumn(name = "project_id"))
    private List < Project > projects = new ArrayList <Project>();

    public Employee() {
    	
    }
    
	public Employee(String empName, String email) {
		super();
		this.empName = empName;
		this.email = email;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
}