package entities;

import entities.items.Item;

import java.util.List;

public class Order {

    private List<Item> items;
    private String voucher;

    public Order(List<Item> items, String voucher) {
        this.items = items;
        this.voucher = voucher;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getVoucher() {
        return voucher;
    }
}
