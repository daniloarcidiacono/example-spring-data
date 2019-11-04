package com.objectway.stage.examples.springdata;

import com.objectway.stage.examples.springdata.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();

        try (final SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory()) {
            try (final Session session = sessionFactory.openSession()) {
                // create a couple of events...
//                session.beginTransaction();
//                session.save(new Event("Our very first event!", new Date()));
//                session.save(new Event("A follow up event", new Date()));
//                session.getTransaction().commit();
//                session.close();

                // now lets pull events from the database and list them
                session.beginTransaction();
                final List<Employee> result = session.createQuery("from Employee").list();
                for (Employee employee : result) {
                    System.out.println(employee);
                }
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();

            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
