package homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {

        String filePath = "C:\\Users\\38762\\Downloads\\social_network.csv";

        try {
            Scanner fileScanner = new Scanner(new File(filePath));

            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }


            SocialNetwork network = new SocialNetwork(fileScanner);


            System.out.println("Total users: " + network.getTotalUsers());
            System.out.println("Total friendships: " + network.getTotalFriendships());


            Scanner inputScanner = new Scanner(System.in);
            while (true) {
                System.out.println("Enter a name and surname to recommend friends to, or -1 to exit:");
                String input = inputScanner.nextLine();
                if (input.equals("-1")) {
                    break;
                }

                if (network.userExists(input)) {
                    ArrayList<FriendshipRecommendation> recommendations = network.recommendFriends(input);
                    System.out.println("Total recommendations: " + recommendations.size());
                    recommendations.stream().limit(10).forEach(System.out::println);
                } else {
                    System.out.println("User not found in the network.");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        }
    }
}
