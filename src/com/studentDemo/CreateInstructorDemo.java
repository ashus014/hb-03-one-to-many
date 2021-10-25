package com.studentDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateDemo.Course;
import com.hibernateDemo.Instructor;
import com.hibernateDemo.InstructorDetail;
import com.hibernateDemo.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
				Instructor tempInstructor = new Instructor("Ashu","Singh","singh@thug.com");
				
				InstructorDetail tempInstructorDetail = new InstructorDetail("Thugs of Jharkhand", "Beer Thodna");
				
				tempInstructor.setInstructorDetail(tempInstructorDetail);
				
				session.beginTransaction();
				
				session.save(tempInstructor);
			
				session.getTransaction().commit();
			
		}
		finally {
			
				session.close();
				factory.close();
		}
		
	}
}
