package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;


public class QueryStudent {

	public static void main(String[] args) {
		
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();

		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").list();
			
			//display the students
			System.out.println("Display all the students");
			displayStudents(theStudents);
			
			// query students: lastName = Wall
			theStudents = session.createQuery("from Student s Where s.lastName='Wall'").list();
			
			// display the students with last name wall
			System.out.println("\nStudents who have last name of Wall");
			displayStudents(theStudents);
			
			//query students: lastname = Wall or firstname = Mary
			theStudents = session.createQuery("from Student s Where s.lastName='Wall' OR s.firstName = 'Mary'").list();
			
			//display the students with last name wall or first name mary
			System.out.println("\nStudents who have last name of Wall or firstname Mary");
			displayStudents(theStudents);
			
			
			// query student where email ends with gmail
			 theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").list();
			 
			 // display the students where email ends with gmail.com
			 System.out.println("\nstudents with email ending with gmail.com");
			 displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
		
			System.out.println("\nDone!");
			
		}
		
		finally {
			
			factory.close();
			
		}
		
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent:theStudents) {
			System.out.println(tempStudent);
			
		}
	}

}
