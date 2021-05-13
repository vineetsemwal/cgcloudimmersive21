package com.cg.empmswithdb.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    EntityManagerFactory emf;

    private static JpaUtil instance = new JpaUtil();

    public static JpaUtil getInstance(){
        return instance;
    }

    private JpaUtil() {

    }


    public EntityManager newEntityManager() {
        if (emf == null) {
            emf = createEntityManagerFactory();
        }
        EntityManager entityManager = emf.createEntityManager();
        return entityManager;
    }

    public EntityManagerFactory createEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("emp-ms");

    }

}
