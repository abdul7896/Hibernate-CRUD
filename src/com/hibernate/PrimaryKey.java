package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class PrimaryKey {

	public static void main(String[] args) {
		

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();

		
		try {
			
			// create three student object
			System.out.println("Creating three new student object");
			Student tempStudent1 = new Student("John","Doe","john@gmail.com");
			Student tempStudent2 = new Student("Mary","Public","mary@gmail.com");
			Student tempStudent3 = new Student("Bonita","Apple","bonita@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			
			// save student object
			System.out.println("Saving the student");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
		
		
	
	}

}
