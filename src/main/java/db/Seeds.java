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

        Food food1 = new Food("Yoghurt", FoodCategory.FRUIT_AND_VEG, 0.50, 10, "Strawberry, Fruit & Veg", new GregorianCalendar(2018, 3, 23), shop);
        Food food2 = new Food("Fish fingers", FoodCategory.FROZEN, 2.50, 10, "Birds eye, Frozen", new GregorianCalendar(2018, 3, 23), shop);
        Food food3 = new Food("Cheese", FoodCategory.DAIRY, 2.50, 10, "Mature Cheddar, Dairy", new GregorianCalendar(2018, 3, 23), shop);
        Food food4 = new Food("Bacon", FoodCategory.MEAT, 3.50, 10, "Unsmoked, Meat", new GregorianCalendar(2018, 3, 23), shop);
        Food food5 = new Food("Chorizo", FoodCategory.MEAT, 2.50, 10, "Spicy, Meat", new GregorianCalendar(2018, 3, 23), shop);
        Food food6 = new Food("Peperami", FoodCategory.MEAT, 1.00, 10, "Spicy, Meat", new GregorianCalendar(2018, 3, 23), shop);
        Food food7 = new Food("Pepporoni", FoodCategory.MEAT, 0.50, 10, "Spicy, Meat", new GregorianCalendar(2018, 3, 23), shop);
        Food food8 = new Food("7up", FoodCategory.DRINK, 1.50, 10, "2L, Drink", new GregorianCalendar(2018, 3, 23), shop);
        Food food9 = new Food("Dr pepper", FoodCategory.DRINK, 1.50, 10, "2L, Drink", new GregorianCalendar(2018, 3, 23), shop);
        Food food10 = new Food("Irn-bru", FoodCategory.DRINK, 1.50, 10, "2L, Drink", new GregorianCalendar(2018, 3, 23), shop);
        Food food11 = new Food("Lucozade", FoodCategory.DRINK, 1.50, 10, "500ml, Drink", new GregorianCalendar(2018, 3, 23), shop);
        Food food12 = new Food("Pepsi-max", FoodCategory.DRINK, 1.50, 10, "2L, Drink", new GregorianCalendar(2018, 3, 23), shop);
        Food food13 = new Food("Bagels", FoodCategory.BREAD, 1.50, 10, "Seeded, Bread", new GregorianCalendar(2018, 3, 23), shop);
        Food food14 = new Food("Brown bread", FoodCategory.BREAD, 1.00, 10, "Hovis, Bread", new GregorianCalendar(2018, 3, 23), shop);
        Food food32 = new Food("White bread", FoodCategory.BREAD, 1.00, 10, "Hovis, Bread", new GregorianCalendar(2018, 3, 23), shop);
        Food food15 = new Food("Rolls", FoodCategory.BREAD, 1.00, 10, "6pk Soft, Bread", new GregorianCalendar(2018, 3, 23), shop);
        Food food16 = new Food("Cookies", FoodCategory.BREAD, 1.00, 10, "Chocolate Chip, Bread", new GregorianCalendar(2018, 3, 23), shop);
        Food food17 = new Food("Donuts", FoodCategory.BREAD, 1.00, 10, "Chocolate, Bread", new GregorianCalendar(2018, 3, 23), shop);
        Food food18 = new Food("Bananas", FoodCategory.FRUIT_AND_VEG, 1.00, 10, "Bunch, Fruit & Veg", new GregorianCalendar(2018, 3, 23), shop);
        Food food19 = new Food("Lemons", FoodCategory.FRUIT_AND_VEG, 1.00, 10, "Organic, Fruit & Veg", new GregorianCalendar(2018, 3, 23), shop);
        Food food20 = new Food("Limes", FoodCategory.FRUIT_AND_VEG, 1.00, 10, "Organic, Fruit & Veg", new GregorianCalendar(2018, 3, 23), shop);
        Food food21 = new Food("Mango", FoodCategory.FRUIT_AND_VEG, 1.00, 10, "Organic, Fruit & Veg", new GregorianCalendar(2018, 3, 23), shop);
        Food food22 = new Food("Oranges", FoodCategory.FRUIT_AND_VEG, 1.00, 10, "Organic, Fruit & Veg", new GregorianCalendar(2018, 3, 23), shop);
        Food food23 = new Food("Butter", FoodCategory.DAIRY, 1.00, 10, "Spreadable, Dairy", new GregorianCalendar(2018, 3, 23), shop);
        Food food25 = new Food("Milk", FoodCategory.DAIRY, 1.00, 10, "2L green, Dairy", new GregorianCalendar(2018, 3, 23), shop);
        Food food26 = new Food("Milk", FoodCategory.DAIRY, 1.00, 10, "2L blue, Dairy", new GregorianCalendar(2018, 3, 23), shop);
        Food food27 = new Food("Chips", FoodCategory.FROZEN, 2.99, 10, "McCains, Frozen", new GregorianCalendar(2018, 3, 23), shop);
        Food food28 = new Food("Peas", FoodCategory.FROZEN, 2.99, 10, "green, Frozen", new GregorianCalendar(2018, 3, 23), shop);
        Food food29 = new Food("Pizza", FoodCategory.FROZEN, 2.99, 10, "pepperoni, Frozen", new GregorianCalendar(2018, 3, 23), shop);
        Food food30 = new Food("Potato-waffles", FoodCategory.FROZEN, 2.99, 10, "McCains, Frozen", new GregorianCalendar(2018, 3, 23), shop);
        Food food33 = new Food("Cheerios", FoodCategory.CEREALS, 2.99, 10, "500g, Cereal", new GregorianCalendar(2018, 3, 23), shop);
        Food food34 = new Food("Corn flakes", FoodCategory.CEREALS, 2.99, 10, "500g, Cereal", new GregorianCalendar(2018, 3, 23), shop);
        Food food35 = new Food("Crunchy nut corn flakes", FoodCategory.CEREALS, 2.99, 10, "500g, Cereal", new GregorianCalendar(2018, 3, 23), shop);
        Food food36 = new Food("Weetabix", FoodCategory.CEREALS, 2.99, 10, "500g, Cereal", new GregorianCalendar(2018, 3, 23), shop);

        Clothing clothing1 = new Clothing("Longsleeve-Black", ClothingCategory.JUMPERS, 20.00, 10, "Large, Jumper", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing2 = new Clothing("Longsleeve-Gray", ClothingCategory.JUMPERS, 20.00, 10, "Large, Jumper", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing3 = new Clothing("Longsleeve-Pink", ClothingCategory.JUMPERS, 20.00, 10, "Large, Jumper", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing4 = new Clothing("Longsleeve-Striped", ClothingCategory.JUMPERS, 20.00, 10, "Large, Jumper", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing5 = new Clothing("Raincoat-Black", ClothingCategory.JACKETS, 30.00, 10, "Medium, Jacket", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing6 = new Clothing("Raincoat-Blue", ClothingCategory.JACKETS, 30.00, 10, "Large, Jacket", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing7 = new Clothing("Raincoat-Red", ClothingCategory.JACKETS, 30.00, 10, "Medium, Jacket", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing8 = new Clothing("Raincoat-Yellow", ClothingCategory.JACKETS, 30.00, 10, "Small, Jacket", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing9 = new Clothing("Batman", ClothingCategory.T_SHIRTS, 15.00, 10, "Small, T-shirt", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing10 = new Clothing("Superman", ClothingCategory.T_SHIRTS, 15.00, 10, "Small, T-shirt", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing11 = new Clothing("Yellow", ClothingCategory.T_SHIRTS, 15.00, 10, "Small, T-shirt", new GregorianCalendar(2018, 3, 23), shop);
        Clothing clothing12 = new Clothing("Black", ClothingCategory.T_SHIRTS, 15.00, 10, "Small, T-shirt", new GregorianCalendar(2018, 3, 23), shop);

        Health health1 = new Health("Body wash", HealthCategory.BODYWASH, 3.00, 10, "500ml, Bodywash", new GregorianCalendar(2018, 3, 23), shop);
        Health health2 = new Health("Shampoo", HealthCategory.HAIRCARE, 3.00, 10, "500ml, Haircare", new GregorianCalendar(2018, 3, 23), shop);
        Health health3 = new Health("Shower gel", HealthCategory.BODYWASH, 3.00, 10, "500ml, Bodywash", new GregorianCalendar(2018, 3, 23), shop);
        Health health4 = new Health("Fish oils", HealthCategory.VITAMINS, 3.00, 10, "30 tablets, Vitamins", new GregorianCalendar(2018, 3, 23), shop);
        Health health5 = new Health("Vitamin c", HealthCategory.VITAMINS, 3.00, 10, "30 tablets, Vitamins", new GregorianCalendar(2018, 3, 23), shop);
        Health health6 = new Health("Vitamin d", HealthCategory.VITAMINS, 3.00, 10, "30 tablets, Vitamins", new GregorianCalendar(2018, 3, 23), shop);
        Health health7 = new Health("Multi-vitamin", HealthCategory.VITAMINS, 3.00, 10, "30 tablets, Vitamins", new GregorianCalendar(2018, 3, 23), shop);
        Health health8 = new Health("Mouthwash", HealthCategory.ORALCARE, 3.00, 10, "250ml, Oralcare", new GregorianCalendar(2018, 3, 23), shop);
        Health health9 = new Health("Toothpaste", HealthCategory.ORALCARE, 3.00, 10, "250ml, Oralcare", new GregorianCalendar(2018, 3, 23), shop);
        Health health10 = new Health("Sun cream", HealthCategory.SUNCARE_TRAVEL, 3.00, 10, "Factor 20, Suncare & Travel", new GregorianCalendar(2018, 3, 23), shop);
        Health health11 = new Health("Sun cream", HealthCategory.SUNCARE_TRAVEL, 3.00, 10, "Factor 30, Suncare & Travel", new GregorianCalendar(2018, 3, 23), shop);
        Health health12 = new Health("Sun cream", HealthCategory.SUNCARE_TRAVEL, 3.00, 10, "Factor 50, Suncare & Travel", new GregorianCalendar(2018, 3, 23), shop);


        food1.setImage("/images/yoghurts.jpg");
        food2.setImage("/images/fish-fingers.jpg");
        food3.setImage("/images/cheese.jpg");
        food4.setImage("/images/bacon.jpg");
        food5.setImage("/images/chorizo.jpg");
        food6.setImage("/images/peperami.jpg");
        food7.setImage("/images/pepperoni.jpg");
        food8.setImage("/images/7up.jpg");
        food9.setImage("/images/dr-pepper.jpg");
        food10.setImage("/images/irn-bru.jpg");
        food11.setImage("/images/lucozade.jpg");
        food12.setImage("/images/pepsi-max.jpg");
        food13.setImage("/images/bagels.jpg");
        food14.setImage("/images/brown-bread.jpg");
        food32.setImage("/images/white-bread.jpg");
        food15.setImage("/images/rolls.jpg");
        food16.setImage("/images/cookies.jpg");
        food17.setImage("/images/donuts.jpg");
        food18.setImage("/images/bananas.jpg");
        food19.setImage("/images/lemons.jpg");
        food20.setImage("/images/limes.jpg");
        food21.setImage("/images/mango.jpg");
        food22.setImage("/images/oranges.jpg");
        food23.setImage("/images/butter.jpg");
        food25.setImage("/images/milk-blue.jpg");
        food26.setImage("/images/milk-green.jpg");
        food27.setImage("/images/chips.jpg");
        food28.setImage("/images/peas.jpg");
        food29.setImage("/images/pizza.jpg");
        food30.setImage("/images/potato-waffles.jpg");
        food33.setImage("/images/cheerios.jpg");
        food34.setImage("/images/corn-flakes.jpg");
        food35.setImage("/images/crunchy-nut-cornflakes.jpg");
        food36.setImage("/images/weetabix.jpg");

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
        DBHelper.saveOrUpdate(food25);
        DBHelper.saveOrUpdate(food26);
        DBHelper.saveOrUpdate(food27);
        DBHelper.saveOrUpdate(food28);
        DBHelper.saveOrUpdate(food29);
        DBHelper.saveOrUpdate(food30);
        DBHelper.saveOrUpdate(food32);
        DBHelper.saveOrUpdate(food33);
        DBHelper.saveOrUpdate(food34);
        DBHelper.saveOrUpdate(food35);
        DBHelper.saveOrUpdate(food36);

        clothing1.setImage("/images/black-jumper.jpeg");
        clothing2.setImage("/images/gray-jumper.jpeg");
        clothing3.setImage("/images/pink-jumper.jpeg");
        clothing4.setImage("/images/striped-jumper.jpeg");
        clothing5.setImage("/images/black-jacket.jpeg");
        clothing6.setImage("/images/blue-jacket.jpeg");
        clothing7.setImage("/images/red-jacket.jpeg");
        clothing8.setImage("/images/yellow-jacket.jpeg");
        clothing9.setImage("/images/batman-shirt.jpeg");
        clothing10.setImage("/images/superman-shirt.jpeg");
        clothing11.setImage("/images/yellow-shirt.jpeg");
        clothing12.setImage("/images/t-shirt.jpeg");

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

        health1.setImage("/images/body-wash.jpg");
        health2.setImage("/images/shampoo.jpg");
        health3.setImage("/images/shower-gel.jpg");
        health4.setImage("/images/fish-oils.jpg");
        health5.setImage("/images/vitamin-c.jpg");
        health6.setImage("/images/vitamin-d.jpg");
        health7.setImage("/images/multi-vitamin.jpg");
        health8.setImage("/images/mouthwash.jpg");
        health9.setImage("/images/toothpaste.jpg");
        health10.setImage("/images/sun-20.jpg");
        health11.setImage("/images/sun-30.jpg");
        health12.setImage("/images/sun-50.jpg");


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
