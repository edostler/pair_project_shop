package ClassTests;

import models.Shop;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShopTest {

    private Shop shop;

    @Before
    public void setUp() throws Exception {
        shop = new Shop("PPS Groceries");
    }

    @Test
    public void testName() {
        assertEquals("PPS Groceries", shop.getName());
    }

}
