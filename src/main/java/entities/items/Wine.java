package entities.items;

public class Wine extends Beverage{

    public Wine(double price) {
        super(price);
    }

    @Override
    public boolean isRestrictedItem() {
        return true;
    }
}
