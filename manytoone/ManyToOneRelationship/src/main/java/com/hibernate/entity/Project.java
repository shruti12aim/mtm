package com.hibernate.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity  
@Table(name="project")  
public class Project {
	
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
    
    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="project")
    private List<Employee> employees;
        
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

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}


/*

The mappedBy attribute is used to indicate that entities have a bidirectional association/relationship. It is used on the non-owning side of the relationship, which is the entity that does not have a foreign key in the table. The mappedBy attribute specifies that the other entity maps (builds/establishes) the relationship by adding a foreign key to the entity's table. This foreign key references the primary key of the non-owning side entity's table to establish the relationship between the entities.

*/