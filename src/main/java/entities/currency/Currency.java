package entities.currency;

public enum Currency {

    TND{
        @Override
        public double convertFromTND(double price) {
            return price;
        }
    },
    USD {
        @Override
        public double convertFromTND(double price) {
            return price * 0.34;
        }
    },
    EUR{
        @Override
        public double convertFromTND(double price) {
            return price*0.31;
        }
    };

    public abstract double convertFromTND(double price);
}
