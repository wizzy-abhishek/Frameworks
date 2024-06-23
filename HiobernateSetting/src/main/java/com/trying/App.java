package com.trying;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.trying.entity.Records;

public class App {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Records.class).buildSessionFactory();
		
		Session session = fac.getCurrentSession();
		
		try {
			/*// Create
			 * Records rec = new Records("abcd" , "abcd" , "ab" , "cd");
			 * session.beginTransaction(); 
			 * session.save(rec);
			 * session.getTransaction().commit();
			 */
			
			/*//Read
			 * Records rec = new Records();
			 * session.beginTransaction(); rec =
			 * session.get(Records.class, 2); 
			 * session.getTransaction().commit();
			 * System.out.print(rec);
			 */
			
			/*
			 * // Update 
			 * Records rec = new Records(); 
			 * session.beginTransaction(); 
			 * rec = session.get(Records.class, 3);
			 * rec.setFirst_name("Ajay");
			 * rec.setLast_name("Choudhary");
			 *  rec.setUsername("Ajay08");
			 * rec.setPassword("Hello"); 
			 * session.getTransaction().commit();
			 * System.out.print(rec);
			 */
			
			// Delete 
			Records rec = new Records();
			session.beginTransaction();
			rec = session.get(Records.class, 1);
			session.delete(rec);
			session.getTransaction().commit();
			
			
		}finally {
			session.close();
			fac.close();
		}
	
	}

}