package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
			
			Instructor tempInstructor = new Instructor("aditya","surabhi","aditya@gmail.com");
			
			InstructorDetail tempInstructorDetail= new InstructorDetail("http://www.luv2code.com","code for better");
			
			
			
			// associate the objects
			
			tempInstructor.setInstructordetail(tempInstructorDetail);
			
	
			
			
			
			
			//start a transaction
			
			//this will also save the details object because of cascade.ALL
			
			System.out.println("Saving Instructor:" + tempInstructor); 
			session.beginTransaction();
			
			
		
		
			
			
			
			// save the instructor
			session.save(tempInstructor);
			
			
		
			
			
			
			//commit transaction
			session.getTransaction().commit();
		
		
		
		
		}
		finally {
			factory.close();
		}
	}

}
