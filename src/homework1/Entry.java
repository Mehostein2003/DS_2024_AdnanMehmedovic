package homework1;

public class Entry implements Comparable<Entry> {
    private String name;
    private String address;
    private String city;
    private String postcode;
    private String country;
    private String phoneNumber;

    public Entry(String name, String address, String city, String postcode, String country, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Entry other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + ";" + address + ";" + city + ";" + postcode + ";" + country + ";" + phoneNumber;
    }
}