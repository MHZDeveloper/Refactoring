package entities.address;

public enum Country {
    FRANCE {
        @Override
        public double getDeliveryFee() {
            return 15;
        }
    },
    CANADA {
        @Override
        public double getDeliveryFee() {
            return 30;
        }
    },
    TUNISIA {
        @Override
        public double getDeliveryFee() {
            return 5;
        }
    },
    USA {
        @Override
        public double getDeliveryFee() {
            return 30;
        }
    };

    public abstract double getDeliveryFee();
}
