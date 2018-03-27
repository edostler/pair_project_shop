package ClassTests;

import models.Customer;
import models.Shop;
import models.PreviousPurchase;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer customer;
    Shop shop;


    private PreviousPurchase previousPurchase;
    private GregorianCalendar purchaseDate;
    private GregorianCalendar deliveryDate;

    @Before
    public void setUp() throws Exception {
        shop = new Shop("PPS Groceries");
        customer = new Customer("James Bond", "Bond007", 20, shop);
        purchaseDate = new GregorianCalendar(2020, 5, 10);
        deliveryDate = new GregorianCalendar(2020, 5, 28);
        previousPurchase = new PreviousPurchase(0, customer, purchaseDate, deliveryDate, shop);
    }

    @Test
    public void testName() {
        assertEquals("James Bond", customer.getName());
    }

    @Test
    public void testUsername() {
        assertEquals("Bond007", customer.getUsername());
    }

    @Test
    public void testDistance() {
        assertEquals(20, customer.getDistance());
    }

    @Test
    public void testLifetimeSpendStartsAt0(){
        assertEquals(0, customer.getLifetimeSpend(), 0.01);
    }

    @Test
    public void canCheckPreviousPurchasesSize() {
        assertEquals(0, customer.checkPreviousPurchasesSize());
    }

    @Test
    public void canAddPreviousPurchaseToPreviousPurchases() {
        customer.addPreviousPurchaseToPreviousPurchases(previousPurchase);
        assertEquals(1, customer.checkPreviousPurchasesSize());
    }

}
