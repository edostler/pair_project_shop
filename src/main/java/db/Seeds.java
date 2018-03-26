package db;

import models.*;

import java.util.GregorianCalendar;
import java.util.List;

public class Seeds {

    public static void seedData() {

        DBHelper.deleteAll(Food.class);
        DBHelper.deleteAll(Clothing.class);
        DBHelper.deleteAll(Health.class);
        DBHelper.deleteAll(Product.class);
        DBHelper.deleteAll(Customer.class);
        DBHelper.deleteAll(CurrentPurchase.class);
        DBHelper.deleteAll(PreviousPurchase.class);
        DBHelper.deleteAll(Purchase.class);
        DBHelper.deleteAll(Shop.class);

        Shop shop = new Shop("PPS Groceries");
        DBHelper.saveOrUpdate(shop);

        Customer customer1 = new Customer("James Bond", "Bond007", 20, shop);
        Customer customer2 = new Customer("Clark Kent", "Superman01", 30, shop);
        Customer customer3 = new Customer("Bruce Wayne", "Batman01", 55, shop);
        Customer customer4 = new Customer("Peter Parker", "Spiderman01", 5, shop);
        DBHelper.saveOrUpdate(customer1);
        DBHelper.saveOrUpdate(customer2);
        DBHelper.saveOrUpdate(customer3);
        DBHelper.saveOrUpdate(customer4);

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

        CurrentPurchase currentPurchase1 = new CurrentPurchase(0.00, customer1);
        CurrentPurchase currentPurchase2 = new CurrentPurchase(0.00, customer2);
        CurrentPurchase currentPurchase3 = new CurrentPurchase(0.00, customer3);
        DBHelper.saveOrUpdate(currentPurchase1);
        DBHelper.saveOrUpdate(currentPurchase2);
        DBHelper.saveOrUpdate(currentPurchase3);

//        customer1.setBasket(currentPurchase1);
//        DBHelper.saveOrUpdate(customer1);

        PreviousPurchase previousPurchase1 = new PreviousPurchase(0.00, customer1, new GregorianCalendar(2018, 2, 22), new GregorianCalendar(2018, 2, 23), shop);
        PreviousPurchase previousPurchase2 = new PreviousPurchase(0.00, customer1, new GregorianCalendar(2018, 2, 28), new GregorianCalendar(2018, 3, 01), shop);
        PreviousPurchase previousPurchase3 = new PreviousPurchase(0.00, customer1, new GregorianCalendar(2018, 3, 06), new GregorianCalendar(2018, 3, 07), shop);
        DBHelper.saveOrUpdate(previousPurchase1);
        DBHelper.saveOrUpdate(previousPurchase2);
        DBHelper.saveOrUpdate(previousPurchase3);

        DBHelper.addProductToPurchase(food1, currentPurchase1);
        DBHelper.addProductToPurchase(clothing1, currentPurchase2);
        DBHelper.addProductToPurchase(health1, currentPurchase3);

        DBHelper.addProductToPurchase(food2, previousPurchase1);
        DBHelper.addProductToPurchase(clothing2, previousPurchase1);
        DBHelper.addProductToPurchase(health2, previousPurchase2);
        DBHelper.addProductToPurchase(food3, previousPurchase2);
        DBHelper.addProductToPurchase(clothing3, previousPurchase3);
        DBHelper.addProductToPurchase(health3, previousPurchase3);

        Customer foundCustomer = DBHelper.find(Customer.class, customer1.getId());

        List<PreviousPurchase> foundPreviousPurchases = DBHelper.getAll(PreviousPurchase.class);

    }

}
