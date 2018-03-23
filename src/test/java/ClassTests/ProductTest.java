package ClassTests;

import models.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    Product product;

    @Before
    public void setUp() throws Exception {
        product = new Product("milk", 1.99, true, 1, "2l Semi-Skimmed", new GregorianCalendar(2018,3,23));
    }

    @Test
    public void testName() {
        assertEquals("milk", product.getName());
    }

    @Test
    public void testPrice() {
        assertEquals(1.99, product.getPrice());
    }

    @Test
    public void testAvailability() {
        assertEquals(true, product.getAvailabilty());
    }

    @Test
    public void testQuantity() {
        assertEquals(1, product.getQuantity());
    }

    @Test
    public void testDescription() {
        assertEquals("2l Semi-Skimmed", product.getDescription());
    }

    @Test
    public void testStockDate() {
        assertEquals(new GregorianCalendar(2018,3,23), product.getDate());
    }
}

