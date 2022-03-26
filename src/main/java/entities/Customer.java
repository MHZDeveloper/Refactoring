package entities;

import entities.address.Address;

public class Customer {

    private String name;
    private String membership;
    private Address address;

    public Customer(String name, String membership, Address address) {
        this.name = name;
        this.membership = membership;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getMembership() {
        return membership;
    }

    public Address getAddress() {
        return address;
    }
}
