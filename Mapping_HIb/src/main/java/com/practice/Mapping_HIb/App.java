package com.practice.Mapping_HIb;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.practice.Mapping_HIb.pojo.Laptop;
import com.practice.Mapping_HIb.pojo.Student;

public class App
{
    public static void main( String[] args )
    {
    	
		/*
		 * Student student = new Student(); student.setRoll(22);
		 * student.setName("Athrav"); student.setBranch("CSE");
		 */
          
		/*
		 * Laptop laptop = new Laptop(); laptop.setlId(107); laptop.setlName("HP");
		 * laptop.setStudent(student);
		 */
       
        
       // student.getLaptop().add(laptop);
        
        Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class) ;
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sf = config.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        //session.persist(student);
        // session.persist(laptop);
        
        
		/*
		 * Student student = session.get(Student.class, 6);
		 * 
		 * Laptop laptop = new Laptop(); laptop.setlId(106); laptop.setlName("Razor");
		 * laptop.setStudent(student); student.getLaptop().add(laptop);
		 * session.persist(laptop);
		 */
        
        Student student = session.get(Student.class, 6);
        System.out.println(student);
		/*
		 * List<Laptop> laptops = student.getLaptop();
		 * 
		 * for(Laptop laptop : laptops) { System.out.println(laptop); }
		 */
        
        tx.commit();
    }
}
