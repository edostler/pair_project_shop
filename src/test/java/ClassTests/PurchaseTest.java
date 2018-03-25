package ClassTests;

import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class PurchaseTest {

    private CurrentPurchase currentPurchase;
    private Customer customer;
    private Food foodProduct;
    private Shop shop;



    @Before
    public void setUp() throws Exception {
        shop = new Shop("PPS Groceries");
        customer = new Customer("Ed", "edostler", 25, shop);
        currentPurchase = new CurrentPurchase(0, customer);
        foodProduct  = new Food("stawberry milk", FoodCategory.FRUIT_AND_VEG, 3.99, 10, "Yazoo 500ml", new GregorianCalendar(2018, 3, 23), shop);
    }

    @Test
    public void testTotal() {
        assertEquals(0, currentPurchase.getTotal(), 0.01);
    }

    @Test
    public void testSetTotal() {
        currentPurchase.setTotal(10.55);
        assertEquals(10.55, currentPurchase.getTotal(), 0.01);
    }

    @Test
    public void canCheckContentsSize() {
        assertEquals(0, currentPurchase.checkContentsSize());
    }

    @Test
    public void canAddProductToContents() {
        currentPurchase.addProductToContents(foodProduct);
        assertEquals(1, currentPurchase.checkContentsSize());
    }

    @Test
    public void canRemoveProductFromContents() {
        currentPurchase.addProductToContents(foodProduct);
        assertEquals(1, currentPurchase.checkContentsSize());
        currentPurchase.removeProductFromContents(foodProduct);
        assertEquals(0, currentPurchase.checkContentsSize());
    }
}
