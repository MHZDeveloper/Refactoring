package entities;

import entities.address.Address;
import entities.address.Country;
import entities.items.Item;
import entities.items.Water;
import entities.items.Wine;
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
        List<Item> items = Arrays.asList(new Wine(40), new Water(10));
        Order order = new Order(items,"lol");
        Address address = new Address("address", Country.USA);
        Customer customer = new Customer("MHZ","SILVER",address);

        //when
        double result = purchaseHandler.calculateTotal(order,customer);

        //then
        Assertions.assertThat(result).isEqualTo(80.0);
    }

    @Test
    public void should_calculate_total_without_voucher_and_membership_and_in_TUN() {
        //given
        List<Item> items = Arrays.asList(new Wine(40), new Water(10));
        Order order = new Order(items,"lol");
        Address address = new Address("address", Country.TUNISIA);
        Customer customer = new Customer("MHZ","SILVER",address);

        //when
        double result = purchaseHandler.calculateTotal(order,customer);

        //then
        Assertions.assertThat(result).isEqualTo(55.0);
    }

    @Test
    public void should_calculate_total_without_voucher_and_gold_membership() {
        //given
        List<Item> items = Arrays.asList(new Wine(40), new Water(10));
        Order order = new Order(items,"lol");
        Address address = new Address("address", Country.USA);
        Customer customer = new Customer("MHZ","GOLD",address);

        //when
        double result = purchaseHandler.calculateTotal(order,customer);

        //then
        Assertions.assertThat(result).isEqualTo(50.0);
    }

    @Test
    public void should_calculate_total_voucher_and_gold_membership() {
        //given
        List<Item> items = Arrays.asList(new Wine(40), new Water(10));
        Order order = new Order(items,"discount");
        Address address = new Address("address", Country.USA);
        Customer customer = new Customer("MHZ","GOLD",address);

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