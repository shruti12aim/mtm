package com.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hibernate.entity.Employee;
import com.hibernate.util.HibernateUtil;

public class EmployeeDao {
	
	public void saveEmployee(Employee employee) {
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the employee object
			session.save(employee);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}