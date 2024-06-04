package homework3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class PhonebookV2 {
    /* Color codes for the output */
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        RedBlackTree tree = null;


        try {
            System.out.println("Loading the entries...");
            tree = FileUtils.readFile("raw_phonebook_data.csv"); // Update the path to your CSV file
        } catch (IOException e) {
            System.out.println("Error loading the file: " + e.getMessage());
            return;
        }


        int[] edgeCounts = tree.countRedAndBlackEdges();
        System.out.println("=======================================");
        System.out.println("System is ready.");
        System.out.println("Total " + ANSI_RED + "red edges" + ANSI_RESET + " in the tree: " + edgeCounts[1]);
        System.out.println("Total black edges in the tree: " + edgeCounts[0]);

        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.print("\nEnter a name that you wish to search for, or -1 to exit: ");
            String input = scanner.nextLine().trim();


            if (input.equals("-1")) {
                break;
            }


            ArrayList<Entry> results = tree.get(input);

            if (results != null) {
                System.out.println("Entries found: " + results.size());

                for (Entry entry : results) {
                    System.out.println(entry);
                }
            } else {
                System.out.println("No entries with the given name exist in the phonebook...");
            }
        }

        scanner.close();
        System.out.println("Thank you for using the phonebook!");
    }
}
