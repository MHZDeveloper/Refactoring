package entities.items;

public abstract class Beverage extends Item {

    public Beverage(double price) {
        super(price);
    }

    public abstract boolean isRestrictedItem();
}
