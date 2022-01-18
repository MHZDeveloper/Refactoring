package entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class PurchaseHandler {

    private LocalDate deliveryStartDate;
    private LocalDate deliveryEndDate;

    public void setDeliveryTimeWindow (LocalDate start, LocalDate end) {
        this.deliveryStartDate = start;
        this.deliveryEndDate= end;
        System.out.println("the delivery time window is between "+this.deliveryStartDate+" and "+ this.deliveryEndDate);
    }

    public double calculateTotal(Order order, Customer customer) {

        double total = 0;

        // ******* methods extracted************

        total = sumItemPrices(order.getItems(), total);

        total = applyVoucher(order.getVoucher(), total);

        total = addDeliveryFee(customer.getMembership(), customer.getAddress(), total);

        // ******* methods extracted************

        return total;
    }

    private double sumItemPrices(List<Item> items, double total) {
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    private double applyVoucher(String voucher, double total) {
        if (isValidVoucher(voucher)) {
            total = BigDecimal.valueOf(total *0.95).setScale(2).doubleValue();
        } else {
            System.out.println("Voucher Invalid");
        }
        return total;
    }

    private boolean isValidVoucher(String voucher) {
        return voucher.equalsIgnoreCase("DISCOUNT") || voucher.equalsIgnoreCase("CHEAPER");
    }

    private double addDeliveryFee(String membership, String address, double total) {
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
