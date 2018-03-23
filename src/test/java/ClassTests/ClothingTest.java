package ClassTests;

import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class ClothingTest {

    Clothing jeans;
    Shop shop;

    @Before
    public void setUp() throws Exception {
        shop = new Shop("PPS Groceries");
        jeans = new Clothing("jeans", ClothingCategory.TROUSERS, 34.99, 10, "Blue Jeans, 34L", new GregorianCalendar(2018, 3, 23), shop);
    }

    @Test
    public void testCategory() {
        assertEquals(ClothingCategory.TROUSERS, jeans.getCategory());
    }

    @Test
    public void testSetCategory() {
        jeans.setCategory(ClothingCategory.JUMPERS);
        assertEquals(ClothingCategory.JUMPERS, jeans.getCategory());
    }
}
