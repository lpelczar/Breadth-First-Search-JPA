package com.codecool.bfsexample;

import com.codecool.bfsexample.model.UserNode;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

class Database {

    static List<UserNode> populateDB(EntityManager em) {
        List<UserNode> users = new RandomDataGenerator().generate();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        for (UserNode user : users) {
            em.persist(user);
        }
        transaction.commit();
        GraphPlotter.plot(users);
        return users;
    }
}
