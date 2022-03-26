package entities;

import entities.address.Address;
import entities.address.Country;

public class DeliveryManager {

    public double addDeliveryFee(String membership, Address address, double total) {
        if (isGoldMembership(membership)){
            System.out.println("Gold membership");
        } else {
            if (address.getCountry().equals(Country.FRANCE)) {
                total +=15;
            } else if (address.getCountry().equals(Country.USA)|| address.getCountry().equals(Country.CANADA)) {
                total +=30;
            } else {
                total +=5;
            }
        }
        return total;
    }

    private boolean isGoldMembership(String membership) {
        return membership.equalsIgnoreCase("GOLD");
    }
}
