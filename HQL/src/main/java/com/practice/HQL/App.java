package com.practice.HQL;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.query.sql.internal.SQLQueryParser;

import com.practice.HQL.POJO.Student;

public class App 
{
    @SuppressWarnings("deprecation")
	public static void main( String[] args )
    {
        Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
        
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        
        SessionFactory sf = config.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        
//		
//		 Random r = new Random();
//		 
//		 for(int i = 1 ; i <= 50 ; i++) { Student s = new Student(); s.setRoll(i);
//		 s.setName("Pomegranate" + i); s.setMarks(r.nextInt(100)); session.persist(s);
//		 
//		 }
//		
        
		
//		 Query<Student> q = session.createQuery("from Student where marks > 50");
//		 List<Student> stu = q.list();
//		 
//		 for(Student st : stu) { System.out.println(st); }
		
		
//		 Query<Student> q = session.createQuery("from Student where roll = 6");
//		 Student st = q.uniqueResult(); System.out.println(st);
		
        
//        Query q = session.createQuery("select roll , name , marks from Student ");
//        List<Object[]> students = (List<Object[]>) q.list();
//        
		
//		 for(Object[] student : students) {
//		 System.out.println(Arrays.toString(student)); }
//		
//		 for(Object[] student : students) { System.out.println(student[0] + " : " +
//		student[1] + " : " + student[2]); }
		
        
//		
//		  int set = 60 ; Query q = session.
//		  createQuery("select roll , name , marks from Student where marks > :abc ");
//		  q.setParameter("abc", set); List<Object[]> students = (List<Object[]>)
//		  q.list(); System.out.println("From HQL Query : "); for(Object[] student :
//		  students) { System.out.println(student[0] + " : " + student[1] + " : " +
//		  student[2]); }
//		 
        
        //Student stu = session.find(Student.class, 6) ;
        
        Student stu1 = session.load(Student.class, 1);
        
        
        //System.out.println(stu);
        
        tx.commit();
        session.close();
        sf.close();
        
        
    }
}
