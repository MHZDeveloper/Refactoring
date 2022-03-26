package entities.items;

public class Water extends Beverage{

    public Water(double price) {
        super(price);
    }

    @Override
    public boolean isRestrictedItem() {
        return false;
    }
}
