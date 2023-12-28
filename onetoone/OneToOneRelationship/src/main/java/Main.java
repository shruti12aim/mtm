import java.util.Calendar;
import java.util.Date;

import com.hibernate.dao.EmployeeDao;
import com.hibernate.entity.Employee;
import com.hibernate.entity.Project;

public class Main {
	public static void main(String[] args) {

		Employee employee = new Employee("Scott", "scott@gmail.com");
		
		Calendar cal=Calendar.getInstance();
		cal.set(2023, 12, 13);
		Date startDate=cal.getTime();
		
		cal.set(2024, 3, 30);
		Date releaseDate=cal.getTime();

		Project project = new Project("LMS","IBM");
		project.setStartDate(startDate);
		project.setReleaseDate(releaseDate);

		employee.setProject(project);
		
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.saveEmployee(employee);
		
		Employee employeee = new Employee("Rose", "rose@gmail.com");
		
		cal=Calendar.getInstance();
		cal.set(2023, 12, 13);
		startDate=cal.getTime();
		
		cal.set(2024, 3, 29);
		releaseDate=cal.getTime();

		project = new Project("EMS","Wipro");
		project.setStartDate(startDate);
		project.setReleaseDate(releaseDate);

		employeee.setProject(project);
		
		employeeDao = new EmployeeDao();
		employeeDao.saveEmployee(employeee);
	}
}

