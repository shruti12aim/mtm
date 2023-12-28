import java.util.Calendar;
import java.util.Date;

import com.hibernate.dao.EmployeeDao;
import com.hibernate.dao.ProjectDao;
import com.hibernate.entity.Employee;
import com.hibernate.entity.Project;


public class Main {
	public static void main(String[] args) {

		EmployeeDao employeeDao = new EmployeeDao();
		
		Calendar cal=Calendar.getInstance();
		cal.set(2023, 12, 14);
		Date startDate=cal.getTime();
		
		cal.set(2024, 03, 30);
		Date releaseDate=cal.getTime();

		Project project = new Project("LMS","IBM");
		project.setStartDate(startDate);
		project.setReleaseDate(releaseDate);
		
		ProjectDao projectDao=new ProjectDao();
		projectDao.saveProject(project);

		Employee employee = new Employee("Scott", "scott@gmail.com");
		employee.setProject(project);
		employeeDao.saveEmployee(employee);
		
		employee = new Employee("Rose", "rose@gmail.com");
		employee.setProject(project);
		employeeDao.saveEmployee(employee);
		
		employee = new Employee("Mark", "mark@gmail.com");
		employee.setProject(project);
		employeeDao.saveEmployee(employee);
	}
}