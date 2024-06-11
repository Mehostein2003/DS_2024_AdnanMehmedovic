package homework4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SocialNetwork {
    private int V;
    private int E;
    private HashMap<String, ArrayList<Friendship>> adj;


    public SocialNetwork() {
        this.V = 0;
        this.E = 0;
        this.adj = new HashMap<>();
    }


    public SocialNetwork(Scanner in) {
        this();
        while (in.hasNextLine()) {
            String[] tokens = in.nextLine().split(";");
            if (tokens.length == 3) {
                String friend1 = tokens[0];
                String friend2 = tokens[1];
                int friendshipStrength = Integer.parseInt(tokens[2]);
                addFriendship(new Friendship(friend1, friend2, friendshipStrength));
            }
        }
    }


    public void addUser(String user) {
        if (!adj.containsKey(user)) {
            adj.put(user, new ArrayList<>());
            V++;
        }
    }


    public void addFriendship(Friendship f) {
        String friend1 = f.getFriend1();
        String friend2 = f.getFriend2();

        addUser(friend1);
        addUser(friend2);

        adj.get(friend1).add(f);
        adj.get(friend2).add(new Friendship(friend2, friend1, f.getFriendshipStrength()));
        E++;
    }


    public ArrayList<FriendshipRecommendation> recommendFriends(String user) {
        Set<String> directFriends = new HashSet<>();
        Set<String> recommendedFriends = new HashSet<>();
        HashMap<String, Integer> recommendationStrengths = new HashMap<>();

        if (!adj.containsKey(user)) {
            return new ArrayList<>();
        }

        for (Friendship f : adj.get(user)) {
            directFriends.add(f.getFriend2());
        }

        for (String friend : directFriends) {
            for (Friendship f : adj.get(friend)) {
                String potentialFriend = f.getFriend2();
                if (!potentialFriend.equals(user) && !directFriends.contains(potentialFriend)) {
                    recommendedFriends.add(potentialFriend);
                    recommendationStrengths.put(potentialFriend, recommendationStrengths.getOrDefault(potentialFriend, 0) + f.getFriendshipStrength());
                }
            }
        }

        ArrayList<FriendshipRecommendation> recommendations = new ArrayList<>();
        for (String recommendedFriend : recommendedFriends) {
            recommendations.add(new FriendshipRecommendation(recommendedFriend, recommendationStrengths.get(recommendedFriend)));
        }

        Collections.sort(recommendations);
        return recommendations;
    }


    public int getTotalUsers() {
        return V;
    }

    public int getTotalFriendships() {
        return E;
    }


    public boolean userExists(String user) {
        return adj.containsKey(user);
    }
}