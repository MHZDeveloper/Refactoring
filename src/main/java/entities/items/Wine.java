package entities.items;

public class Wine extends Item{

    public Wine(double price) {
        super(price);
    }

    @Override
    public boolean isRestrictedBeverage() {
        return true;
    }
}
