package entities;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class PurchaseHandlerTest {

    private PurchaseHandler purchaseHandler = new PurchaseHandler();

    @Test
    public void should_calculate_total_without_voucher_and_membership_and_not_in_TUN() {
        //given
        List<Item> items = Arrays.asList(new Item(40), new Item(10));
        Order order = new Order(items,"lol");
        Customer customer = new Customer("MHZ","SILVER","address, US");

        //when
        double result = purchaseHandler.calculateTotal(order,customer);

        //then
        Assertions.assertThat(result).isEqualTo(80.0);
    }

    @Test
    public void should_calculate_total_without_voucher_and_membership_and_in_TUN() {
        //given
        List<Item> items = Arrays.asList(new Item(40), new Item(10));
        Order order = new Order(items,"lol");
        Customer customer = new Customer("MHZ","SILVER","address, TUN");

        //when
        double result = purchaseHandler.calculateTotal(order,customer);

        //then
        Assertions.assertThat(result).isEqualTo(60.0);
    }

    @Test
    public void should_calculate_total_without_voucher_and_gold_membership() {
        //given
        List<Item> items = Arrays.asList(new Item(40), new Item(10));
        Order order = new Order(items,"lol");
        Customer customer = new Customer("MHZ","GOLD","address, US");

        //when
        double result = purchaseHandler.calculateTotal(order,customer);

        //then
        Assertions.assertThat(result).isEqualTo(50.0);
    }

    @Test
    public void should_calculate_total_voucher_and_gold_membership() {
        //given
        List<Item> items = Arrays.asList(new Item(40), new Item(10));
        Order order = new Order(items,"discount");
        Customer customer = new Customer("MHZ","GOLD","address, US");

        //when
        double result = purchaseHandler.calculateTotal(order,customer);

        //then
        Assertions.assertThat(result).isEqualTo(47.5);
    }

    @Test
    public void should_set_window_time() {
        //given
        LocalDate start = LocalDate.of(2022, Month.JANUARY,20);
        LocalDate end = LocalDate.of(2022, Month.JANUARY,21);
        Period period = new Period(start,end);

        //when
        purchaseHandler.setDeliveryTimeWindow(period);

        //then
        Assertions.assertThat(purchaseHandler.getDeliveryTimeWindow())
                .hasFieldOrPropertyWithValue("startDate",start)
                .hasFieldOrPropertyWithValue("endDate",end);
    }
}