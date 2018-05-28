package com.codecool.bfsexample;

import com.codecool.bfsexample.model.UserNode;

import java.util.*;

class UserGraph {

    private List<UserNode> nodes;

    UserGraph(List<UserNode> nodes) {
        this.nodes = nodes;
    }

    int getDistanceBetweenTwoUsers(UserNode user1, UserNode user2) {
        Queue<UserNode> queue = new LinkedList<>();
        queue.add(user1);
        user1.setVisited(true);
        while (!queue.isEmpty()) {
            UserNode parent = queue.remove();
            UserNode child;
            while ((child = getUnvisitedChildNode(parent)) != null) {
                child.setVisited(true);

                child.setDistance(parent.getDistance() + 1);
                if (child == user2) {
                    return child.getDistance();
                }

                queue.add(child);
            }
        }
        return -1;
    }



    private UserNode getUnvisitedChildNode(UserNode node) {
        UserNode unvisitedNode = null;
        for (UserNode userNode : node.getFriends()) {
            if (!userNode.isVisited()) {
                unvisitedNode = userNode;
            }
        }
        return unvisitedNode;
    }

    private void clearNodes() {
        for (UserNode userNode : nodes) {
            userNode.setDistance(0);
            userNode.setVisited(false);
        }
    }
}
