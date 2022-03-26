package entities.address;

public class Address {

    private String address;
    private Country country;

    public Address(String address, Country country) {
        this.address = address;
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
