import db.DBHelper;
import models.*;

import java.util.GregorianCalendar;

public class Runner {

    public static void main(String[] args) {

        Shop shop = new Shop("PPS Groceries");
        DBHelper.saveOrUpdate(shop);


        Food food1 = new Food("yoghurt", FoodCategory.FRUIT_AND_VEG, 0.50, 10, "Muller Rice, strawberry flavour", new GregorianCalendar(2018, 3, 23), shop);
        Food food2 = new Food("fish fingers", FoodCategory.FROZEN, 0.50, 10, "Birds eye", new GregorianCalendar(2018, 3, 23), shop);
        Food food3 = new Food("cheese", FoodCategory.DAIRY, 0.50, 10, "Mature Cheddar", new GregorianCalendar(2018, 3, 23), shop);
        DBHelper.saveOrUpdate(food1);
        DBHelper.saveOrUpdate(food2);
        DBHelper.saveOrUpdate(food3);

        User user1 = new User("James Bond", "Bond007", 20, shop);
        User user2 = new User("Clark Kent", "Superman01", 30, shop);
        User user3 = new User("Bruce Wayne", "Batman01", 55, shop);
        User user4 = new User("Peter Parker", "Spiderman01", 5, shop);
        DBHelper.saveOrUpdate(user1);
        DBHelper.saveOrUpdate(user2);
        DBHelper.saveOrUpdate(user3);
        DBHelper.saveOrUpdate(user4);



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


        CurrentOrder currentOrder1 = new CurrentOrder(0, user1);
        CurrentOrder currentOrder2 = new CurrentOrder(0, user2);
        CurrentOrder currentOrder3 = new CurrentOrder(0, user3);
        DBHelper.saveOrUpdate(currentOrder1);
        DBHelper.saveOrUpdate(currentOrder2);
        DBHelper.saveOrUpdate(currentOrder3);

        PreviousOrder previousOrder1 = new PreviousOrder(0, user1, new GregorianCalendar(2018, 2, 22), new GregorianCalendar(2018, 2, 23), shop);
        PreviousOrder previousOrder2 = new PreviousOrder(0, user1, new GregorianCalendar(2018, 2, 28), new GregorianCalendar(2018, 3, 01), shop);
        PreviousOrder previousOrder3 = new PreviousOrder(0, user1, new GregorianCalendar(2018, 3, 06), new GregorianCalendar(2018, 3, 07), shop);
        DBHelper.saveOrUpdate(previousOrder1);
        DBHelper.saveOrUpdate(previousOrder2);
        DBHelper.saveOrUpdate(previousOrder3);
    }
}
