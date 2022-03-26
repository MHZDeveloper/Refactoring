import entities.*;
import entities.address.Address;
import entities.address.Country;
import entities.currency.Currency;
import entities.items.Chocolate;
import entities.items.Item;
import entities.items.Water;
import entities.items.Wine;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // initialize customer
        Address address = new Address("address", Country.TUNISIA);
        Customer customer = new Customer("MHZ","GOLD",address);

        // initialize shopping list
        List<Item> shoppingList = Arrays.asList(new Water(10), new Wine(50), new Chocolate(40));

        //initialize order
        Order order = new Order(shoppingList,"voucher");

        // calculate total
        PurchaseHandler purchaseHandler = new PurchaseHandler();
        double total = purchaseHandler.calculateTotal(order,customer);
        System.out.println("Total (TND) is "+total);
        total = Currency.EUR.convertFromTND(total);
        System.out.println("Total (EUR) is "+total);
        Period period = new Period(LocalDate.now().plusDays(1),LocalDate.now().plusDays(3));
        purchaseHandler.setDeliveryTimeWindow(period);
    }
}
