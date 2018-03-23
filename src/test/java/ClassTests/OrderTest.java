package ClassTests;

import models.CurrentOrder;
import models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    private CurrentOrder currentOrder;
    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User("Ed", "edostler", 25);
        currentOrder = new CurrentOrder(user);
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
}
