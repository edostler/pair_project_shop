package ClassTests;

import models.Food;
import models.FoodCategory;
import models.Health;
import models.HealthCategory;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class HealthTest {

    Health shampoo;

    @Before
    public void setUp() throws Exception {
        shampoo = new Health("shampoo", HealthCategory.BODYWASH, 2.99, 10, "Head and shoulders, 500ml", new GregorianCalendar(2018, 3, 23));
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
