package com.example;


import java.math.BigDecimal;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PetShopDAO {

	public void addPet(String name, String color, String price) {
		try {
			Configuration configuration = new Configuration();
			SessionFactory sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Pets pets = new Pets();
			pets.setName(name);
			pets.setColor(color);
			pets.setPrice(BigDecimal.valueOf(Double.parseDouble(price)));
			session.save(pets);
			transaction.commit();
			session.close();
		} catch(HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}
	}
}
