package ClassTests;

import models.Food;
import models.FoodCategory;
import models.Product;
import models.Shop;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProductTest {

    Food product;
    Food product2;
    Shop shop;

    @Before
    public void setUp() throws Exception {
        shop = new Shop("PPS Groceries");

        product = new Food("milk", FoodCategory.DAIRY, 1.99, 1, "2l Semi-Skimmed", new GregorianCalendar(2018,3,30), shop);
        product2 = new Food("bread", FoodCategory.BREAD, 1.99, 0, "Warbutons wholemeal", new GregorianCalendar(2018,3,23), shop);
    }

    @Test
    public void testName() {
        assertEquals("milk", product.getName());
    }

    @Test
    public void testSetName() {
        product.setName("soy milk");
        assertEquals("soy milk", product.getName());
    }

    @Test
    public void testPrice() {
        assertEquals(1.99, product.getPrice(), 0.01);
    }

    @Test
    public void testSetPrice(){
        product.setPrice(1.50);
        assertEquals(1.50, product.getPrice(), 0.01);


    }

    @Test
    public void testAvailability() {
        assertTrue(product.getAvailability());
        assertFalse(product2.getAvailability());
    }


    @Test
    public void testQuantity() {
        assertEquals(1, product.getQuantity());
    }

    @Test
    public void testSetQuantity() {
        product2.setQuantity(5);
        assertEquals(5,product2.getQuantity());
        assertTrue(product2.getAvailability());


    }

    @Test
    public void testDescription() {
        assertEquals("2l Semi-Skimmed", product.getDescription());
    }

    @Test
    public void testSetDescription() {
        product.setDescription("3l Semi-Skimmed");
        assertEquals("3l Semi-Skimmed", product.getDescription());
    }

    @Test
    public void testStockDate() {
        assertEquals(2018, product.getStockDate().get(GregorianCalendar.YEAR));
        assertEquals(3, product.getStockDate().get(GregorianCalendar.MONTH));
        assertEquals(30, product.getStockDate().get(GregorianCalendar.DAY_OF_MONTH));
    }


}

