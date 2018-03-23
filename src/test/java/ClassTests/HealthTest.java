package ClassTests;

import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class HealthTest {

    Health shampoo;
    Shop shop;

    @Before
    public void setUp() throws Exception {
        shop = new Shop("PPS Groceries");
        shampoo = new Health("shampoo", HealthCategory.BODYWASH, 2.99, 10, "Head and shoulders, 500ml", new GregorianCalendar(2018, 3, 23), shop);
    }

    @Test
    public void testCategory() {
        assertEquals(HealthCategory.BODYWASH, shampoo.getCategory());
    }

    @Test
    public void testSetCategory() {
        shampoo.setCategory(HealthCategory.HAIRCARE);
        assertEquals(HealthCategory.HAIRCARE, shampoo.getCategory());
    }
}
