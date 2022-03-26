package entities.items;

public class Chocolate extends Item{

    public Chocolate(double price) {
        super(price);
    }

    @Override
    public boolean isRestrictedBeverage() {
        return false;
    }
}
