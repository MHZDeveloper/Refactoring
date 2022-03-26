package entities.items;

public abstract class Item {

    private double price;

    public Item(double price) {
        this.price = price;
    }

    public abstract boolean isRestrictedBeverage();

    public double getPrice() {
        return price;
    }
}
