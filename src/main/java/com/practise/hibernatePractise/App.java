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
public class App 
{
    public static void main( String[] args )
    {	
    	Student student = new Student();
    	student.setId(1);
    	student.setName("Ashik Md Shakil");
    	student.setDepartment("SWE");
    	student.setUniversity("Daffodil International University");
    	
        Configuration config = new Configuration();
        config.configure().addAnnotatedClass(Student.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sf = config.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction txn = session.beginTransaction();
       
        txn.commit();
        
    }
}
