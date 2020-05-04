package com.practise.hibernatePractise;

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

		student.setId(1);
		student.setDepartment("Software Engineering");
		student.setUniversity("Daffodil International University");
		Laptop laptop = new Laptop();   
		laptop.setId(1);
		laptop.setCompanyName("Dell");
		laptop.setMacAdress("3453453");
		laptop.setStudent(student);
		student.getLaptop().add(laptop);

		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sf = config.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction txn = session.beginTransaction();
		// student = (Student) session.get(Student.class,1);
		session.save(student);
		session.save(laptop);
		txn.commit();
		// System.out.println(student);
		// System.out.println(student.getLaptop());

	}
}
