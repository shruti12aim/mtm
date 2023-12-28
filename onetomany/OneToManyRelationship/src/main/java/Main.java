import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.hibernate.dao.EmployeeDao;
import com.hibernate.entity.Employee;
import com.hibernate.entity.Project;


public class Main
{
	public static void main(String[] args) {

		Employee employee = new Employee("Scott", "scott@gmail.com");
		
		List<Project> projects=new ArrayList<Project>();
		
		Calendar cal=Calendar.getInstance();
		cal.set(2023, 12, 14);
		Date startDate=cal.getTime();
		
		cal.set(2024, 3, 30);
		Date releaseDate=cal.getTime();

		Project project = new Project("LMS","IBM");
		project.setStartDate(startDate);
		project.setReleaseDate(releaseDate);
		project.setEmployee(employee);
		
		projects.add(project);
		
		cal=Calendar.getInstance();
		cal.set(2023, 12, 14);
		startDate=cal.getTime();
		
		cal.set(2024, 03, 30);
		releaseDate=cal.getTime();

		project = new Project("CMS","Wipro");
		project.setStartDate(startDate);
		project.setReleaseDate(releaseDate);
		project.setEmployee(employee);
		
		projects.add(project);
		
		employee.setProjects(projects);
		
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.saveEmployee(employee);
		
	}
}