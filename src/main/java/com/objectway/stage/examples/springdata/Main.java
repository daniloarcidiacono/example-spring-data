package com.objectway.stage.examples.springdata;

import com.objectway.stage.examples.springdata.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;

        try {
            // like discussed with regards to SessionFactory, an EntityManagerFactory is set up once for an application
            // 		IMPORTANT: notice how the name here matches the name we gave the persistence-unit in persistence.xml!
            emf = Persistence.createEntityManagerFactory( "MyPersistenceUnit");

            // now lets pull events from the database and list them
            EntityManager em = null;
            try {
                em = emf.createEntityManager();
                em.getTransaction().begin();
                final List<Employee> result = em.createQuery("from Employee", Employee.class).getResultList();
                for (Employee employee : result) {
                    System.out.println(employee);
                }

                em.getTransaction().commit();
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (emf != null) {
                emf.close();
            }
        }
    }
}
