package com.AbhishekMaven.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppTest
{

	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{

		Alien obj = new Alien();

		obj.setId(1);
		obj.setName("Abhishek");
		obj.setColor("Blue");

		Configuration config = new Configuration();

		SessionFactory sf = config.buildSessionFactory();

		Session session = sf.openSession();

		session.save(obj);

	}

}
