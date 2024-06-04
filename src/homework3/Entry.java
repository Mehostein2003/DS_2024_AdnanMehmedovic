package homework3;


@SuppressWarnings("all")
public class Entry implements Comparable<Entry> {

    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";


    private String name;
    private String street_address;
    private String city;
    private String postcode;
    private String country;
    private String phone_number;



    public Entry(String name, String street_address, String city, String postcode, String country, String phone_number) {
        this.name = name;
        this.street_address = street_address;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phone_number = phone_number;
    }


    @Override
    public String toString() {
        return  ANSI_BLUE + "Name: " + ANSI_RESET + this.name + "\n" +
                ANSI_BLUE + "Street: " + ANSI_RESET + this.street_address + "\n" +
                ANSI_BLUE + "City: " + ANSI_RESET + this.city + "\n" +
                ANSI_BLUE + "PostCode: " + ANSI_RESET + this.postcode + "\n" +
                ANSI_BLUE + "Country: " + ANSI_RESET + this.country + "\n" +
                ANSI_BLUE + "Phone Number: " + ANSI_RESET + this.phone_number + "\n";
    }


    @Override
    public int compareTo(Entry other) {
        return this.name.compareTo(other.name);
    }


    public String getName() {
        return name;
    }
}