package entities.items;

public class Water extends Item{

    public Water(double price) {
        super(price);
    }

    @Override
    public boolean isRestrictedBeverage() {
        return false;
    }
}
