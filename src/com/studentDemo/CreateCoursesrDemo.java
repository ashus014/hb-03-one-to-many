package com.studentDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateDemo.Course;
import com.hibernateDemo.Instructor;
import com.hibernateDemo.InstructorDetail;
import com.hibernateDemo.Student;

public class CreateCoursesrDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
				
				session.beginTransaction();
				
				int theId = 1;
				Instructor tempInstructor = session.get(Instructor.class, theId);
				
				Course tempCourse1 = new Course("Pool Bandhna");
				Course tempCourse2 = new Course("Patake Banana");
				
				tempInstructor.add(tempCourse1);
				tempInstructor.add(tempCourse2);
				
				session.save(tempCourse1);
				session.save(tempCourse2);
			
				session.getTransaction().commit();
			
		}
		finally {
			
				session.close();
				factory.close();
		}
		
	}
}
