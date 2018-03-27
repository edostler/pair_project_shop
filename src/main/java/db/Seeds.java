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

        Shop shop2 = new Shop("SOLD");
        DBHelper.saveOrUpdate(shop2);

        Customer customer1 = new Customer("James Bond", "Bond007", 20, shop);
        Customer customer2 = new Customer("Clark Kent", "Superman01", 30, shop);
        Customer customer3 = new Customer("Bruce Wayne", "Batman01", 55, shop);
        Customer customer4 = new Customer("Peter Parker", "Spiderman01", 5, shop);
        DBHelper.saveOrUpdate(customer1);
        DBHelper.saveOrUpdate(customer2);
        DBHelper.saveOrUpdate(customer3);
        DBHelper.saveOrUpdate(customer4);

        Food food1 = new Food("yoghurt", FoodCategory.FRUIT_AND_VEG, 50, 10, "Strawberry", new GregorianCalendar(2018, 3, 23), shop);
        Food food2 = new Food("fish fingers", FoodCategory.FROZEN, 250, 10, "Birds eye", new GregorianCalendar(2018, 3, 23), shop);
        Food food3 = new Food("cheese", FoodCategory.DAIRY, 250, 10, "Mature Cheddar", new GregorianCalendar(2018, 3, 23), shop);
        Food food4 = new Food("bacon", FoodCategory.MEAT, 350, 10, "Unsmoked", new GregorianCalendar(2018, 3, 23), shop);
        Food food5 = new Food("chorizo", FoodCategory.MEAT, 250, 10, "Spicy", new GregorianCalendar(2018, 3, 23), shop);
        Food food6 = new Food("peperami", FoodCategory.MEAT, 100, 10, "Spicy", new GregorianCalendar(2018, 3, 23), shop);
        Food food7 = new Food("pepporoni", FoodCategory.MEAT, 050, 10, "Spicy", new GregorianCalendar(2018, 3, 23), shop);
        Food food8 = new Food("7up", FoodCategory.DRINK, 150, 10, "2L", new GregorianCalendar(2018, 3, 23), shop);
        Food food9 = new Food("dr pepper", FoodCategory.DRINK, 150, 10, "2L", new GregorianCalendar(2018, 3, 23), shop);
        Food food31 = new Food("dr pepper", FoodCategory.DRINK, 150, 10, "2L", new GregorianCalendar(2018, 3, 23), shop);
        Food food10 = new Food("irn-bru", FoodCategory.DRINK, 150, 10, "2L", new GregorianCalendar(2018, 3, 23), shop);
        Food food11 = new Food("lucozade", FoodCategory.DRINK, 150, 10, "2L", new GregorianCalendar(2018, 3, 23), shop);
        Food food12 = new Food("pepsi-max", FoodCategory.DRINK, 150, 10, "2L", new GregorianCalendar(2018, 3, 23), shop);
        Food food13 = new Food("bagels", FoodCategory.BREAD, 150, 10, "Seeded", new GregorianCalendar(2018, 3, 23), shop);
        Food food14 = new Food("brown bread", FoodCategory.BREAD, 100, 10, "Hovis", new GregorianCalendar(2018, 3, 23), shop);
        Food food32 = new Food("white bread", FoodCategory.BREAD, 100, 10, "Hovis", new GregorianCalendar(2018, 3, 23), shop);
        Food food15 = new Food("rolls", FoodCategory.BREAD, 100, 10, "6pk Soft", new GregorianCalendar(2018, 3, 23), shop);
        Food food16 = new Food("cookies", FoodCategory.BREAD, 100, 10, "Chocolate Chip", new GregorianCalendar(2018, 3, 23), shop);
        Food food17 = new Food("donuts", FoodCategory.BREAD, 100, 10, "Chocolate", new GregorianCalendar(2018, 3, 23), shop);
        Food food18 = new Food("bananas", FoodCategory.FRUIT_AND_VEG, 100, 10, "Bunch", new GregorianCalendar(2018, 3, 23), shop);
        Food food19 = new Food("lemons", FoodCategory.FRUIT_AND_VEG, 100, 10, "Organic", new GregorianCalendar(2018, 3, 23), shop);
        Food food20 = new Food("limes", FoodCategory.FRUIT_AND_VEG, 100, 10, "Organic", new GregorianCalendar(2018, 3, 23), shop);
        Food food21 = new Food("mango", FoodCategory.FRUIT_AND_VEG, 100, 10, "Organic", new GregorianCalendar(2018, 3, 23), shop);
        Food food22 = new Food("oranges", FoodCategory.FRUIT_AND_VEG, 100, 10, "Organic", new GregorianCalendar(2018, 3, 23), shop);
        Food food23 = new Food("butter", FoodCategory.DAIRY, 100, 10, "Spreadable", new GregorianCalendar(2018, 3, 23), shop);
        Food food24 = new Food("cheese", FoodCategory.DAIRY, 100, 10, "Spreadable", new GregorianCalendar(2018, 3, 23), shop);
        Food food25 = new Food("milk", FoodCategory.DAIRY, 100, 10, "2L green", new GregorianCalendar(2018, 3, 23), shop);
        Food food26 = new Food("milk", FoodCategory.DAIRY, 100, 10, "2L blue", new GregorianCalendar(2018, 3, 23), shop);
        Food food27 = new Food("chips", FoodCategory.FROZEN, 299, 10, "McCains", new GregorianCalendar(2018, 3, 23), shop);
        Food food28 = new Food("peas", FoodCategory.FROZEN, 299, 10, "green", new GregorianCalendar(2018, 3, 23), shop);
        Food food29 = new Food("pizza", FoodCategory.FROZEN, 299, 10, "pepperoni", new GregorianCalendar(2018, 3, 23), shop);
        Food food30 = new Food("potato-waffles", FoodCategory.FROZEN, 299, 10, "McCains", new GregorianCalendar(2018, 3, 23), shop);
        Food food33 = new Food("cheerios", FoodCategory.CEREALS, 299, 10, "500g", new GregorianCalendar(2018, 3, 23), shop);
        Food food34 = new Food("corn flakes", FoodCategory.CEREALS, 299, 10, "500g", new GregorianCalendar(2018, 3, 23), shop);
        Food food35 = new Food("crunchy nut corn flakes", FoodCategory.CEREALS, 299, 10, "500g", new GregorianCalendar(2018, 3, 23), shop);
        Food food36 = new Food("weetabix", FoodCategory.CEREALS, 299, 10, "500g", new GregorianCalendar(2018, 3, 23), shop);

        Clothing clothing1 = new Clothing("Longsleeve-Black", ClothingCategory.JUMPERS, 2000, 10, "Large", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing2 = new Clothing("Longsleeve-Gray", ClothingCategory.JUMPERS, 2000, 10, "Large", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing3 = new Clothing("Longsleeve-Pink", ClothingCategory.JUMPERS, 2000, 10, "Large", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing4 = new Clothing("Longsleeve-Striped", ClothingCategory.JUMPERS, 2000, 10, "Large", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing5 = new Clothing("Raincoat-Black", ClothingCategory.JACKETS, 3000, 10, "Medium", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing6 = new Clothing("Raincoat-Blue", ClothingCategory.JACKETS, 3000, 10, "Large", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing7 = new Clothing("Raincoat-Red", ClothingCategory.JACKETS, 3000, 10, "Medium", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing8 = new Clothing("Raincoat-Yellow", ClothingCategory.JACKETS, 3000, 10, "Small", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing9 = new Clothing("Batman", ClothingCategory.T_SHIRTS, 1500, 10, "Small", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing10 = new Clothing("Superman", ClothingCategory.T_SHIRTS, 1500, 10, "Small", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing11 = new Clothing("Yellow", ClothingCategory.T_SHIRTS, 1500, 10, "Small", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing12 = new Clothing("Black", ClothingCategory.T_SHIRTS, 1500, 10, "Small", new GregorianCalendar(2018, 3, 23), shop);

        Health health1 = new Health("body wash", HealthCategory.BODYWASH, 300, 10, "500ml", new GregorianCalendar(2018, 3, 23), shop);
        Health health2 = new Health("shampoo", HealthCategory.HAIRCARE, 300, 10, "500ml", new GregorianCalendar(2018, 3, 23), shop);
        Health health3 = new Health("shower gel", HealthCategory.BODYWASH, 300, 10, "500ml", new GregorianCalendar(2018, 3, 23), shop);
        Health health4 = new Health("fish oils", HealthCategory.VITAMINS, 300, 10, "30 tablets", new GregorianCalendar(2018, 3, 23), shop);
        Health health5 = new Health("vitamin c", HealthCategory.VITAMINS, 300, 10, "30 tablets", new GregorianCalendar(2018, 3, 23), shop);
        Health health6 = new Health("vitamin d", HealthCategory.VITAMINS, 300, 10, "30 tablets", new GregorianCalendar(2018, 3, 23), shop);
        Health health7 = new Health("multi-vitamin", HealthCategory.VITAMINS, 300, 10, "30 tablets", new GregorianCalendar(2018, 3, 23), shop);
        Health health8 = new Health("mouthwash", HealthCategory.ORALCARE, 300, 10, "250ml", new GregorianCalendar(2018, 3, 23), shop);
        Health health9 = new Health("toothpaste", HealthCategory.ORALCARE, 300, 10, "250ml", new GregorianCalendar(2018, 3, 23), shop);
        Health health10 = new Health("sun cream", HealthCategory.SUNCARE_TRAVEL, 300, 10, "Factor 20", new GregorianCalendar(2018, 3, 23), shop);
        Health health11 = new Health("sun cream", HealthCategory.SUNCARE_TRAVEL, 300, 10, "Factor 30", new GregorianCalendar(2018, 3, 23), shop);
        Health health12 = new Health("sun cream", HealthCategory.SUNCARE_TRAVEL, 300, 10, "Factor 50", new GregorianCalendar(2018, 3, 23), shop);



        DBHelper.saveOrUpdate(food1);
        DBHelper.saveOrUpdate(food2);
        DBHelper.saveOrUpdate(food3);
        DBHelper.saveOrUpdate(food4);
        DBHelper.saveOrUpdate(food5);
        DBHelper.saveOrUpdate(food6);
        DBHelper.saveOrUpdate(food7);
        DBHelper.saveOrUpdate(food8);
        DBHelper.saveOrUpdate(food9);
        DBHelper.saveOrUpdate(food10);
        DBHelper.saveOrUpdate(food11);
        DBHelper.saveOrUpdate(food12);
        DBHelper.saveOrUpdate(food13);
        DBHelper.saveOrUpdate(food14);
        DBHelper.saveOrUpdate(food15);
        DBHelper.saveOrUpdate(food16);
        DBHelper.saveOrUpdate(food17);
        DBHelper.saveOrUpdate(food18);
        DBHelper.saveOrUpdate(food19);
        DBHelper.saveOrUpdate(food20);
        DBHelper.saveOrUpdate(food21);
        DBHelper.saveOrUpdate(food22);
        DBHelper.saveOrUpdate(food23);
        DBHelper.saveOrUpdate(food24);
        DBHelper.saveOrUpdate(food25);
        DBHelper.saveOrUpdate(food26);
        DBHelper.saveOrUpdate(food27);
        DBHelper.saveOrUpdate(food28);
        DBHelper.saveOrUpdate(food29);
        DBHelper.saveOrUpdate(food30);
        DBHelper.saveOrUpdate(food31);
        DBHelper.saveOrUpdate(food32);
        DBHelper.saveOrUpdate(food33);
        DBHelper.saveOrUpdate(food34);
        DBHelper.saveOrUpdate(food35);
        DBHelper.saveOrUpdate(food36);

        DBHelper.saveOrUpdate(clothing1);
        DBHelper.saveOrUpdate(clothing2);
        DBHelper.saveOrUpdate(clothing3);
        DBHelper.saveOrUpdate(clothing4);
        DBHelper.saveOrUpdate(clothing5);
        DBHelper.saveOrUpdate(clothing6);
        DBHelper.saveOrUpdate(clothing7);
        DBHelper.saveOrUpdate(clothing8);
        DBHelper.saveOrUpdate(clothing9);
        DBHelper.saveOrUpdate(clothing10);
        DBHelper.saveOrUpdate(clothing11);
        DBHelper.saveOrUpdate(clothing12);

        DBHelper.saveOrUpdate(health1);
        DBHelper.saveOrUpdate(health2);
        DBHelper.saveOrUpdate(health3);
        DBHelper.saveOrUpdate(health4);
        DBHelper.saveOrUpdate(health5);
        DBHelper.saveOrUpdate(health6);
        DBHelper.saveOrUpdate(health7);
        DBHelper.saveOrUpdate(health8);
        DBHelper.saveOrUpdate(health9);
        DBHelper.saveOrUpdate(health10);
        DBHelper.saveOrUpdate(health11);
        DBHelper.saveOrUpdate(health12);






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
