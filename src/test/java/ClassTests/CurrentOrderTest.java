package ClassTests;

import models.CurrentOrder;
import models.User;
import org.junit.Before;

public class CurrentOrderTest {

    private CurrentOrder currentOrder;
    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User("Ed", "edostler", 25);
        currentOrder = new CurrentOrder(user);
    }

}
