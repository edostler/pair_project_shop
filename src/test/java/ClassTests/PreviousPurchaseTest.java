package ClassTests;

import models.Customer;
import models.PreviousPurchase;
import models.Shop;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class PreviousPurchaseTest {

    private PreviousPurchase previousPurchase;
    private Customer customer;
    private GregorianCalendar purchaseDate;
    private GregorianCalendar deliveryDate;
    private Shop shop;

    @Before
    public void setUp() throws Exception {
        shop = new Shop("PPS Groceries");
        customer = new Customer("Ed", "edostler", 25, shop);
        purchaseDate = new GregorianCalendar(2020, 5, 10);
        deliveryDate = new GregorianCalendar(2020, 5, 28);
        previousPurchase = new PreviousPurchase(0, customer, purchaseDate, deliveryDate, shop);
    }

    @Test
    public void testPurchaseDateday() {
        assertEquals(10, previousPurchase.getPurchaseDate().get(GregorianCalendar.DAY_OF_MONTH));
    }

    @Test
    public void testPurchaseDatemonth() {
        assertEquals(5, previousPurchase.getPurchaseDate().get(GregorianCalendar.MONTH));
    }

    @Test
    public void testPurchaseDateyear() {
        assertEquals(2020, previousPurchase.getPurchaseDate().get(GregorianCalendar.YEAR));
    }

    @Test
    public void testDeliveryDateday() {
        assertEquals(28, previousPurchase.getDeliveryDate().get(GregorianCalendar.DAY_OF_MONTH));
    }

    @Test
    public void testDeliveryDatemonth() {
        assertEquals(5, previousPurchase.getDeliveryDate().get(GregorianCalendar.MONTH));
    }

    @Test
    public void testDeliveryDateyear() {
        assertEquals(2020, previousPurchase.getDeliveryDate().get(GregorianCalendar.YEAR));
    }

    @Test
    public void testFormatDateToString() {
        assertEquals("28/5/2020", previousPurchase.formatDateToString(deliveryDate));
    }

    @Test
    public void testFormatDateToStringForInput() {
        assertEquals("2020-05-28", previousPurchase.formatDateToStringForInput(deliveryDate));
    }

}
