package com.codecool.bfsexample;

import com.codecool.bfsexample.model.UserNode;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bfsExampleUnit");
        EntityManager em = emf.createEntityManager();
        em.clear();
        List<UserNode> users = Database.populateDB(em);

        UserGraph userGraph = new UserGraph(users);

        UserNode user1 = users.get(0);
        System.out.println(user1);
        UserNode user2 = users.get(7);
        System.out.println(user2);

        int distance = userGraph.getDistanceBetweenTwoUsers(user1, user2);
        System.out.println("Distance: " + distance);

        Set<UserNode> friendsOfFriends1 = userGraph.getFriendsOfFriends(users.get(0), 1);
        System.out.println(friendsOfFriends1);

        Set<UserNode> friendsOfFriends2 = userGraph.getFriendsOfFriends(users.get(7), 1);
        System.out.println(friendsOfFriends2);

        List<UserNode> shortestPath = userGraph.getShortestPath(user1, user2);
        System.out.println(shortestPath);
    }
}
