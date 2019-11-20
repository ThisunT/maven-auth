package org.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main
{
    private static EntityManager em;

    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence
          .createEntityManagerFactory("auth-test");
        em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Users user = new Users();
        user.setId(2);
        user.setUsername("thisun");
        user.setPassword("abc123");
        em.merge(user);

        transaction.commit();
    }
}
