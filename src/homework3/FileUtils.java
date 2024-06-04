package homework3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileUtils {
    public static RedBlackTree readFile(String filePath) throws IOException {
        RedBlackTree tree = new RedBlackTree();
        try{

            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            reader.readLine();
            String line = "";
            int index = 0;

            while((line = reader.readLine()) != null){


                String[] data = line.split(";");
                String[] full_name = data[0].split(",");

                String name = full_name[0].trim() + ", " + full_name[1].trim();
                String street_address = data[1];
                String city = data[2];
                String postcode = data[3];
                String country = data[4];
                String phone_number = data[5];

                Entry entry = new Entry(name, street_address, city, postcode, country, phone_number);
                tree.put(name, entry);
                index++;
            }


            reader.close();
            return tree;
        } catch (IOException e){

            e.printStackTrace();
            throw new IOException("File not found - Something went wrong with Reading the file!");
        }
    }
}