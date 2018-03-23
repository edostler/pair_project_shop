package ClassTests;

import models.Clothing;
import models.ClothingCategory;
import models.Health;
import models.HealthCategory;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class ClothingTest {

    Clothing jeans;

    @Before
    public void setUp() throws Exception {
        jeans = new Clothing("jeans", ClothingCategory.TROUSERS, 34.99, 10, "Blue Jeans, 34L", new GregorianCalendar(2018, 3, 23));
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
