package com.hibernate;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab18C {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

			Course req = (Course)session.load(Course.class, 1);
			System.out.println("*** course info***");
			System.out.println(req);
			
			System.out.println("*** Student info***");
			Set<Student> stus = req.getStudents();
			for(Student s: stus)
				System.out.println(s);
			

			tx.commit();
			session.close();
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null)	tx.rollback();
		}
	}
}