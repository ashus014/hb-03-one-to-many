package com.studentDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateDemo.Instructor;
import com.hibernateDemo.InstructorDetail;
import com.hibernateDemo.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
				
				session.beginTransaction();
				
				int theId = 1;
				
				Instructor tempInstructor = session.get(Instructor.class, theId);
				
				System.out.println("Found Instructor..." + tempInstructor);
				
				if(tempInstructor != null) {
					System.out.println("Deleting Instructor...");
					session.delete(tempInstructor);
				}
				
				session.getTransaction().commit();
			
		}
		finally {
			
				factory.close();
		}
		
	}
}
