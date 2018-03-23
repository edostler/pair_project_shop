package ClassTests;

import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    private CurrentOrder currentOrder;
    private User user;
    private Food foodProduct;
    private Shop shop;



    @Before
    public void setUp() throws Exception {
        shop = new Shop("PPS Groceries");
        user = new User("Ed", "edostler", 25, shop);
        currentOrder = new CurrentOrder(0, user);
        foodProduct  = new Food("stawberry milk", FoodCategory.FRUIT_AND_VEG, 3.99, 10, "Yazoo 500ml", new GregorianCalendar(2018, 3, 23), shop);
    }

    @Test
    public void testTotal() {
        assertEquals(0, currentOrder.getTotal(), 0.01);
    }

    @Test
    public void testSetTotal() {
        currentOrder.setTotal(10.55);
        assertEquals(10.55, currentOrder.getTotal(), 0.01);
    }

    @Test
    public void canCheckContentsSize() {
        assertEquals(0, currentOrder.checkContentsSize());
    }

    @Test
    public void canAddProductToContents() {
        currentOrder.addProductToContents(foodProduct);
        assertEquals(1, currentOrder.checkContentsSize());
    }

    @Test
    public void canRemoveProductFromContents() {
        currentOrder.addProductToContents(foodProduct);
        assertEquals(1, currentOrder.checkContentsSize());
        currentOrder.removeProductFromContents(foodProduct);
        assertEquals(0, currentOrder.checkContentsSize());
    }
}
