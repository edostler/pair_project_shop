package ClassTests;

import models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    User user;

    @Before
    public void setUp() throws Exception {
        user = new User("James Bond", "Bond007", 20);
    }

    @Test
    public void testName() {
        assertEquals("James Bond", user.getName());
    }

    @Test
    public void testUsername() {
        assertEquals("Bond007", user.getUsername());
    }

    @Test
    public void testDistance() {
        assertEquals(20, user.getDistance());
    }

    @Test
    public void testLifetimeSpendStartsAt0(){
        assertEquals(0, user.getLifetimeSpend(), 0.01);
    }




}
