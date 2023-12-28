package com.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee
{
    @Id
    @Column(name="EMP_ID")
    @GeneratedValue
    private int empId;
    
    @Column(name="EMP_NAME", nullable = false)
    private String empName;
    
    @Column(unique=true, nullable=false, length=30)
    private String email;
    
    @OneToMany(targetEntity=Project.class, cascade = CascadeType.ALL, mappedBy="employee")
    private List < Project > projects = new ArrayList < Project > ();

/*
The mappedBy attribute is used to indicate that entities have a bidirectional association/relationship. 
It is used on the non-owning side of the relationship, which is the entity that does not have a foreign key in the table. 
The mappedBy attribute specifies that the other entity maps (builds/establishes) the relationship by adding a foreign key to
 the entity's table. This foreign key references the primary key of the non-owning side entity's table to establish the 
relationship between the entities.

*/
    
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