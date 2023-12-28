/*
CREATE TABLE addresses(address_id INT PRIMARY KEY,
		            city  VARCHAR(30),
                                            zipcode VARCHAR(10));

INSERT INTO addresses VALUES(1, 'Bangalore','56001');
INSERT INTO addresses VALUES(2, 'Mumbai','56002');
INSERT INTO addresses VALUES(3, 'Delhi','56003'); 


CREATE TABLE employee(employee_id INT PRIMARY KEY,
		           name VARCHAR(30),
		           salary DOUBLE,
		           address_id INT,
 FOREIGN KEY(address_id) REFERENCES addresses(address_id));

INSERT INTO employee VALUES(1,'Scott',25000,1);

INSERT INTO employee VALUES(2,'Rose',35000,1);
INSERT INTO employee VALUES(3,'Mark',45000,2);
INSERT INTO employee VALUES(4,'Bush',55000,2);
INSERT INTO employee VALUES(5,'John',65000,3);
INSERT INTO employee VALUES(6,'Peter',75000,3);

COMMIT;

 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import com.hibernate.criteria.entity.Employee;

public class Main {

    public static void main(String[] args) {
        // Create an EntityManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("YourPersistenceUnitName");

        // Create an EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Begin a transaction
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        
        // Get All Employees
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
        criteriaQuery.select(employeeRoot);

        List<Employee> empList = entityManager.createQuery(criteriaQuery).getResultList();
        for (Employee emp : empList) {
            System.out.println("ID=" + emp.getId() + ", Zipcode=" + emp.getAddress().getZipcode());
        }

        // Get with ID
        CriteriaQuery<Employee> criteriaQueryById = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRootById = criteriaQueryById.from(Employee.class);
        criteriaQueryById.select(employeeRootById)
                .where(criteriaBuilder.equal(employeeRootById.get("id"), 3L));

        Employee empById = entityManager.createQuery(criteriaQueryById).getSingleResult();
        System.out.println("Name=" + empById.getName() + ", City=" + empById.getAddress().getCity());

        // Pagination Example
        CriteriaQuery<Employee> criteriaQueryPagination = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRootPagination = criteriaQueryPagination.from(Employee.class);
        criteriaQueryPagination.select(employeeRootPagination)
                .orderBy(criteriaBuilder.desc(employeeRootPagination.get("id")));
        List<Employee> empListPagination = entityManager.createQuery(criteriaQueryPagination)
                .setFirstResult(0)
                .setMaxResults(2)
                .getResultList();
        for (Employee emp4 : empListPagination) {
            System.out.println("Paginated Employees::" + emp4.getId() + "," + emp4.getAddress().getCity());
        }
        
        // Commit the transaction and close resources
        //transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
