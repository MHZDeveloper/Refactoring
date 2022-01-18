package entities;

public class DeliveryManager {

    public double addDeliveryFee(String membership, String address, double total) {
        if (isGoldMembership(membership)){
            System.out.println("Gold membership");
        } else {
            if (address.contains("TUN")) {
                total +=10;
            } else {
                total +=30;
            }
        }
        return total;
    }

    private boolean isGoldMembership(String membership) {
        return membership.equalsIgnoreCase("GOLD");
    }
}
