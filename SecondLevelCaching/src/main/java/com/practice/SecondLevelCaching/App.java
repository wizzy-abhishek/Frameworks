package com.practice.SecondLevelCaching;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.practice.SecondLevelCaching.pojo.Alien;





public class App 
{
    public static void main( String[] args )
    {	
        Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
        
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build(); 
        
        SessionFactory sf = config.buildSessionFactory(registry);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Alien a1 = session.get(Alien.class, 1);
        System.out.println(a1);
        tx.commit();
        session.close();
        
        Alien a2 = session.get(Alien.class, 1);
        System.out.println(a2);
        tx.commit();
        session.clear();
        
        
        
    }
}
