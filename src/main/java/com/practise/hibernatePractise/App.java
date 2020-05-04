package com.practise.hibernatePractise;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Student student = new Student();
	
		//student.setName("Nusrat Jahan Anika");
		//student.setDepartment("Software Engineering");
		//student.setUniversity("Daffodil International University");
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sf = config.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction txn = session.beginTransaction();
		//session.save(student);
		Query query = session.createQuery("from Student where id = 1");
		//List<Student> students = query.list();
		student = (Student) query.uniqueResult();
		txn.commit();
		System.out.println(student);
		
	}
}
