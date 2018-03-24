package ClassTests;

import models.CurrentPurchase;
import models.Shop;
import models.User;
import org.junit.Before;

public class CurrentPurchaseTest {

    private CurrentPurchase currentOrder;
    private User user;
    private Shop shop;

    @Before
    public void setUp() throws Exception {
        shop = new Shop("PPS Groceries");
        user = new User("Ed", "edostler", 25, shop);
        currentOrder = new CurrentPurchase(0, user);
    }

}
