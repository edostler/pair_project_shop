package ClassTests;

import models.Order;
import models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    private Order order;
    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User("Ed", "edostler", 25);
        order = new Order(user);
    }

    @Test
    public void testTotal() {
        assertEquals(0, order.getTotal(), 0.01);
    }

    @Test
    public void testSetTotal() {
        order.setTotal(10.55);
        assertEquals(10.55, order.getTotal(), 0.01);
    }
}
