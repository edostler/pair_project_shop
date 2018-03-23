package ClassTests;

import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class ShopTest {

    private Shop shop;
    private Food foodProduct;
    private PreviousOrder previousOrder;
    private User user;
    private GregorianCalendar orderDate;
    private GregorianCalendar deliveryDate;

    @Before
    public void setUp() throws Exception {
        shop = new Shop("PPS Groceries");
        foodProduct  = new Food("stawberry milk", FoodCategory.FRUIT_AND_VEG, 3.99, 10, "Yazoo 500ml", new GregorianCalendar(2018, 3, 23));
        user = new User("Ed", "edostler", 25);
        orderDate = new GregorianCalendar(2020, 5, 10);
        deliveryDate = new GregorianCalendar(2020, 5, 28);
        previousOrder = new PreviousOrder(user, orderDate, deliveryDate);
    }

    @Test
    public void testName() {
        assertEquals("PPS Groceries", shop.getName());
    }

    @Test
    public void canCheckStockSize() {
        assertEquals(0, shop.checkStockSize());
    }

    @Test
    public void canCheckAllOrdersSize() {
        assertEquals(0, shop.checkAllOrdersSize());
    }

    @Test
    public void canAddProductToStock() {
        shop.addProductToStock(foodProduct);
        assertEquals(1, shop.checkStockSize());
    }

    @Test
    public void canAddPreviousOrderToAllOrders() {
        shop.addPreviousOrderToAllOrders(previousOrder);
        assertEquals(1, shop.checkAllOrdersSize());
    }

    @Test
    public void canRemoveProductFromStock() {
        shop.addProductToStock(foodProduct);
        assertEquals(1, shop.checkStockSize());
        shop.removeProductFromStock(foodProduct);
        assertEquals(0, shop.checkStockSize());
    }
}
