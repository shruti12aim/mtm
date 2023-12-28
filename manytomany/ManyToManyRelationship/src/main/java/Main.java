import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.hibernate.dao.EmployeeDao;
import com.hibernate.dao.ProjectDao;
import com.hibernate.entity.Employee;
import com.hibernate.entity.Project;


public class Main {
	
	public static void main(String[] args) {

		EmployeeDao employeeDao = new EmployeeDao();
		
		Calendar cal=Calendar.getInstance();
		cal.set(2023, 12, 18);
		Date startDate1=cal.getTime();
		cal.set(2024, 3, 27);
		Date releaseDate1=cal.getTime();
		
		cal=Calendar.getInstance();
		cal.set(2023, 12, 18);
		Date startDate2=cal.getTime();
		cal.set(2024, 3, 28);
		Date releaseDate2=cal.getTime();
		
		cal=Calendar.getInstance();
		cal.set(2023, 12, 18);
		Date startDate3=cal.getTime();
		cal.set(2024, 3, 29);
		Date releaseDate3=cal.getTime();
		
		Project project1 = new Project("LMS","IBM");
		project1.setStartDate(startDate1);
		project1.setReleaseDate(releaseDate1);
		
		Project project2 = new Project("CMS","Wipro");
		project2.setStartDate(startDate2);
		project2.setReleaseDate(releaseDate2);
		
		Project project3 = new Project("PMS","CTS");
		project3.setStartDate(startDate3);
		project3.setReleaseDate(releaseDate3);

		ProjectDao projectDao=new ProjectDao();
		projectDao.saveProject(project1);
		projectDao.saveProject(project2);
		projectDao.saveProject(project3);
		
		List<Project> projects= new ArrayList<Project>();
	        	projects.add(project1);
		projects.add(project2);
        
		Employee employee1 = new Employee("Scott", "scott@gmail.com");
		employee1.setProjects(projects);
		employeeDao.saveEmployee(employee1);
		
		Employee employee2 = new Employee("Mark", "mark@gmail.com");

	                projects= new ArrayList<Project>();
        	                projects.add(project1);
	                projects.add(project3);

	                employee2.setProjects(projects);
        	                employeeDao.saveEmployee(employee2);
		
	                Employee employee3 = new Employee("Rose", "rose@gmail.com");
		 
        	                projects= new ArrayList<Project>();
	                projects.add(project3);
		
                	employee3.setProjects(projects);
	                employeeDao.saveEmployee(employee3);
	}
}