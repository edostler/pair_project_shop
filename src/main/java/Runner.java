import db.DBHelper;
import models.*;

import java.util.GregorianCalendar;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Shop shop = new Shop("PPS Groceries");
        DBHelper.saveOrUpdate(shop);

        User user1 = new User("James Bond", "Bond007", 20, shop);
        User user2 = new User("Clark Kent", "Superman01", 30, shop);
        User user3 = new User("Bruce Wayne", "Batman01", 55, shop);
        User user4 = new User("Peter Parker", "Spiderman01", 5, shop);
        DBHelper.saveOrUpdate(user1);
        DBHelper.saveOrUpdate(user2);
        DBHelper.saveOrUpdate(user3);
        DBHelper.saveOrUpdate(user4);

        Food food1 = new Food("yoghurt", FoodCategory.FRUIT_AND_VEG, 0.50, 10, "Muller Rice, strawberry flavour", new GregorianCalendar(2018, 3, 23), shop);
        Food food2 = new Food("fish fingers", FoodCategory.FROZEN, 0.50, 10, "Birds eye", new GregorianCalendar(2018, 3, 23), shop);
        Food food3 = new Food("cheese", FoodCategory.DAIRY, 0.50, 10, "Mature Cheddar", new GregorianCalendar(2018, 3, 23), shop);
        DBHelper.saveOrUpdate(food1);
        DBHelper.saveOrUpdate(food2);
        DBHelper.saveOrUpdate(food3);


        Clothing clothing1 = new Clothing("jeans", ClothingCategory.TROUSERS, 34.99, 10, "Blue Jeans, 34L", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing2 = new Clothing("t-shirt", ClothingCategory.T_SHIRTS, 34.99, 10, "Blue Polo", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing3 = new Clothing("t-shirt", ClothingCategory.T_SHIRTS, 34.99, 10, "Black Polo", new GregorianCalendar(2018, 3, 23), shop);
        DBHelper.saveOrUpdate(clothing1);
        DBHelper.saveOrUpdate(clothing2);
        DBHelper.saveOrUpdate(clothing3);

        Health health1 = new Health("shampoo", HealthCategory.HAIRCARE, 2.99, 10, "Head and shoulders, 500ml", new GregorianCalendar(2018, 3, 23), shop);
        Health health2 = new Health("vitamin c", HealthCategory.VITAMINS, 2.99, 10, "30 tablets", new GregorianCalendar(2018, 3, 23), shop);
        Health health3 = new Health("toothpaste", HealthCategory.VITAMINS, 2.99, 10, "Colgate", new GregorianCalendar(2018, 3, 23), shop);
        DBHelper.saveOrUpdate(health1);
        DBHelper.saveOrUpdate(health2);
        DBHelper.saveOrUpdate(health3);

        CurrentPurchase currentOrder1 = new CurrentPurchase(0.00, user1);
        CurrentPurchase currentOrder2 = new CurrentPurchase(0.00, user2);
        CurrentPurchase currentOrder3 = new CurrentPurchase(0.00, user3);
        DBHelper.saveOrUpdate(currentOrder1);
        DBHelper.saveOrUpdate(currentOrder2);
        DBHelper.saveOrUpdate(currentOrder3);

        PreviousPurchase previousOrder1 = new PreviousPurchase(0.00, user1, new GregorianCalendar(2018, 2, 22), new GregorianCalendar(2018, 2, 23), shop);
        PreviousPurchase previousOrder2 = new PreviousPurchase(0.00, user1, new GregorianCalendar(2018, 2, 28), new GregorianCalendar(2018, 3, 01), shop);
        PreviousPurchase previousOrder3 = new PreviousPurchase(0.00, user1, new GregorianCalendar(2018, 3, 06), new GregorianCalendar(2018, 3, 07), shop);
        DBHelper.saveOrUpdate(previousOrder1);
        DBHelper.saveOrUpdate(previousOrder2);
        DBHelper.saveOrUpdate(previousOrder3);

        User foundUser = DBHelper.find(User.class, user1.getId());


        List<PreviousPurchase> foundPreviousOrders = DBHelper.getAll(PreviousPurchase.class);
    }
}
