package com.practice.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.practice.ManyToMany.pojo.Laptop;
import com.practice.ManyToMany.pojo.Student;

public class App 
{
    public static void main( String[] args )
    {
    	
    	Student student = new Student();
        student.setRoll(6);
        student.setName("Abhishek Anand");
        student.setBranch("CSE");
          
        Laptop laptop = new Laptop();
        laptop.setlId(103);
        laptop.setlName("DELL");
        laptop.getStudent().add(student);
        
        Laptop laptop1 = new Laptop();
        laptop1.setlId(104);
        laptop1.setlName("Mac");
        laptop1.getStudent().add(student);
        
        student.getLaptop().add(laptop);
        student.getLaptop().add(laptop1);
        
        
        Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class) ;
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sf = config.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        session.persist(laptop1);
        session.persist(student);
        session.persist(laptop);
        
        tx.commit();
    }
}

