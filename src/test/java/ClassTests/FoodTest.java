package ClassTests;

import models.Food;
import models.FoodCategory;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class FoodTest {

    Food food;

    @Before
    public void setUp() throws Exception {
        food = new Food("stawberry milk", FoodCategory.FRUIT_AND_VEG, 3.99, 10, "Yazoo 500ml", new GregorianCalendar(2018, 3, 23));
    }

    @Test
    public void testCategory() {
        assertEquals(FoodCategory.FRUIT_AND_VEG, food.getCategory() );
    }

    @Test
    public void testSetCategory() {
        food.setCategory(FoodCategory.DRINK);
        assertEquals(FoodCategory.DRINK, food.getCategory());
    }
}
