package entities;

import java.math.BigDecimal;

public class DiscountManager {

    public double applyVoucher(String voucher, double total) {
        if (isValidVoucher(voucher)) {
            total = BigDecimal.valueOf(total *0.95).setScale(2).doubleValue();
        } else {
            System.out.println("Voucher Invalid");
        }
        return total;
    }

    private boolean isValidVoucher(String voucher) {
        return voucher.equalsIgnoreCase("DISCOUNT") || voucher.equalsIgnoreCase("CHEAPER");
    }
}
