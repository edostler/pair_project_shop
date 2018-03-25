package ClassTests;

import models.CurrentPurchase;
import models.Customer;
import models.Shop;
import org.junit.Before;

public class CurrentPurchaseTest {

    private CurrentPurchase currentPurchase;
    private Customer customer;
    private Shop shop;

    @Before
    public void setUp() throws Exception {
        shop = new Shop("PPS Groceries");
        customer = new Customer("Ed", "edostler", 25, shop);
        currentPurchase = new CurrentPurchase(0, customer);
    }

}
