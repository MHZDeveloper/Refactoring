package entities;

import entities.address.Address;

public class DeliveryManager {

    public double addDeliveryFee(String membership, Address address, double total) {
        if (isGoldMembership(membership)){
            System.out.println("Gold membership");
        } else {
            total += address.getCountry().getDeliveryFee();
        }
        return total;
    }

    private boolean isGoldMembership(String membership) {
        return membership.equalsIgnoreCase("GOLD");
    }
}
