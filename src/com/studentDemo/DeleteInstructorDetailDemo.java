package com.studentDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateDemo.Instructor;
import com.hibernateDemo.InstructorDetail;
import com.hibernateDemo.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
				
				session.beginTransaction();
				
				int theId = 3; 
				InstructorDetail tempInstructorDetail =  session.get(InstructorDetail.class, theId);
				
				System.out.println("Instructor Detail  " + tempInstructorDetail);
				
				System.out.println(" Associated Instructor :: " + tempInstructorDetail.getInstructor());
				
				tempInstructorDetail.getInstructor().setInstructorDetail(null);
				
				session.delete(tempInstructorDetail);
				
				session.getTransaction().commit();
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		finally {
				session.close();
				factory.close();
		}
		
	}
}
