package com.hibernate.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.ManyToMany;

@Entity  
@Table(name="project")  
public class Project
{
    @Id
    @Column(name="project_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
   	private int projectId;
    
    @Column(name="project_title", nullable = false)
	private String projectTitle;
    
    @Column(name="client_code", nullable = false)
	private String clientCode;
    
    @Column(name="start_date", nullable = false)
	private Date startDate;
    
    @Column(name="release_date", nullable = false)
    private Date releaseDate;
    
    @ManyToMany
    @JoinTable(name = "employee_project",
    joinColumns =  @JoinColumn(name = "project_id"), 
    inverseJoinColumns =  @JoinColumn(name = "emp_id"))
    private List<Employee> employees = new ArrayList<Employee>();
    
    public Project(){
    	
    }

	public Project(String projectTitle, String clientCode) {
		super();
		this.projectTitle = projectTitle;
		this.clientCode = clientCode;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
}
