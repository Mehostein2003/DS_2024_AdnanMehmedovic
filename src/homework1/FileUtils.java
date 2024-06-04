package homework1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static Entry[] readFile(String filePath) throws FileNotFoundException {
        List<Entry> entries = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip the header line
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length == 6) {
                    entries.add(new Entry(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries.toArray(new Entry[0]);
    }

    public static void writeToFile(Entry[] entries, String filePath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("Surname, Name;Street Address;City;Postcode;Country;Phone Number\n");
            for (Entry entry : entries) {
                bw.write(entry.toString() + "\n");
            }
        }
    }
}