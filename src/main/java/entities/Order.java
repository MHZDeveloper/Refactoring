package entities;

import entities.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Order extends ArrayList {

    private List<Item> items;
    private String voucher;

    @Override
    public int size() {
        return items.size();
    }


    @Override
    public int lastIndexOf(Object o) {
        return super.lastIndexOf(o);
    }

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
