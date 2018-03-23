package ClassTests;

import models.CurrentOrder;
import models.Shop;
import models.User;
import org.junit.Before;

public class CurrentOrderTest {

    private CurrentOrder currentOrder;
    private User user;
    private Shop shop;

    @Before
    public void setUp() throws Exception {
        shop = new Shop("PPS Groceries");
        user = new User("Ed", "edostler", 25, shop);
        currentOrder = new CurrentOrder(0, user);
    }

}
