package entities;

import entities.currency.Currency;
import entities.items.Item;

import java.util.List;

public class PurchaseHandler {

    private Period deliveryTimeWindow;
    private DiscountManager discountManager = new DiscountManager();
    private DeliveryManager deliveryManager = new DeliveryManager();

    public void setDeliveryTimeWindow (Period period) {
        this.deliveryTimeWindow = period;
        System.out.println("the delivery time window is between "+this.deliveryTimeWindow.getStartDate()+" and "+ this.deliveryTimeWindow.getEndDate());
    }

    public Period getDeliveryTimeWindow() {
        return deliveryTimeWindow;
    }

    public double calculateTotal(Order order, Customer customer) {

        double total = 0;

        // ******* methods extracted************

        total = sumItemPrices(order.getItems(), total);

        total = discountManager.applyVoucher(order.getVoucher(), total);

        total = deliveryManager.addDeliveryFee(customer.getMembership(), customer.getAddress(), total);

        // ******* methods extracted************

        return total;
    }

    private double sumItemPrices(List<Item> items, double total) {
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
}
