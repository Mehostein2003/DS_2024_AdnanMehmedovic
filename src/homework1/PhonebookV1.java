package homework1;

import java.io.IOException;
import java.util.Scanner;

public class PhonebookV1 {

    public static void main(String[] args) {
        // Specify the absolute path to your CSV file
        String inputFilePath = "C:\\Users\\38762\\Downloads\\raw_phonebook_data.csv";
        String outputFilePath = "C:\\Users\\38762\\Downloads\\sorted_phonebook_data.csv";

        try {
            Entry[] entries = FileUtils.readFile(inputFilePath);
            MergeSort.sort(entries);
            FileUtils.writeToFile(entries, outputFilePath);

            // Create a Scanner object to read user input
            Scanner scanner = new Scanner(System.in);
            String userInput;

            // Loop to allow continuous user input until -1 is entered
            while (true) {
                System.out.println("Enter a Surname, Name combination to search (or -1 to exit): ");
                userInput = scanner.nextLine();

                // Check if user wants to exit
                if (userInput.equals("-1")) {
                    break;
                }

                // Perform search and print results
                searchAndPrint(entries, userInput);
            }

            // Close the scanner
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void searchAndPrint(Entry[] entries, String nameToSearch) {
        int[] resultIndices = BinarySearch.search(entries, nameToSearch);
        if (resultIndices.length == 0) {
            System.out.println("No entries found for " + nameToSearch);
        } else {
            System.out.println("Entries found: " + (resultIndices[1] - resultIndices[0] + 1));
            for (int i = resultIndices[0]; i <= resultIndices[1]; i++) {
                System.out.println(entries[i]);
            }
        }
    }
}