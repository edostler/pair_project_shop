package controllers;

import db.DBHelper;
import models.*;
import spark.template.velocity.VelocityTemplateEngine;

import java.time.LocalDate;
import java.util.*;

import static spark.Spark.get;
import static spark.Spark.post;

import spark.ModelAndView;

public class BasketController {

    public BasketController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {

        get("/basket", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            Customer customer = DBHelper.findCustomerByUsername(loggedInUser);
            CurrentPurchase basket = DBHelper.findBasketForCustomer(customer);
            List<Product> contents = DBHelper.findContentsForBasket(basket);
            model.put("user", loggedInUser);
            model.put("basket", basket);
            model.put("contents", contents);
            model.put("template", "templates/basket/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        post("/basket", (req, res) -> {
            int productId = Integer.parseInt(req.queryParams("id"));
            Product product = DBHelper.find(Product.class, productId);

            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            Customer customer = DBHelper.findCustomerByUsername(loggedInUser);
            CurrentPurchase basket = DBHelper.findBasketForCustomer(customer);
            List<Product> contents = DBHelper.findContentsForBasket(basket);
            basket.setContents(contents);

            int shopQuantity = product.getQuantity();

            String name = product.getName();
            double price = product.getPrice();
            int purchaseQuantity = Integer.parseInt(req.queryParams("quantity"));
            String description = product.getDescription();
            GregorianCalendar stockDate = product.getStockDate();
            Shop shop = DBHelper.findShopByName("SOLD");

            if (shopQuantity < purchaseQuantity) {
                purchaseQuantity = shopQuantity;
            }

            if (product.getClass() == Food.class) {
                Food stockFood = (Food) product;
                FoodCategory foodCategory = stockFood.getCategory();
                Food food = new Food(name, foodCategory, price, purchaseQuantity, description, stockDate, shop);
                DBHelper.saveOrUpdate(food);
                DBHelper.addProductToPurchase(food, basket);
            }
            else if (product.getClass() == Clothing.class) {
                Clothing stockClothing = (Clothing) product;
                ClothingCategory clothingCategory = stockClothing.getCategory();
                Clothing clothing = new Clothing(name, clothingCategory, price, purchaseQuantity, description, stockDate, shop);
                DBHelper.saveOrUpdate(clothing);
                DBHelper.addProductToPurchase(clothing, basket);
            }
            else {
                Health stockHealth = (Health) product;
                HealthCategory healthCategory = stockHealth.getCategory();
                Health health = new Health(name, healthCategory, price, purchaseQuantity, description, stockDate, shop);
                DBHelper.saveOrUpdate(health);
                DBHelper.addProductToPurchase(health, basket);
                }

            int newShopQuantity = shopQuantity - purchaseQuantity;
            product.setQuantity(newShopQuantity);
            boolean availability = product.checkAvailability();
            product.setAvailability(availability);
            DBHelper.saveOrUpdate(product);

            String url = req.headers("referer");
            res.redirect(url);
            return null;
        }, new VelocityTemplateEngine());


        post("/basket/:id/remove", (req, res) ->{
            int productId = Integer.parseInt(req.params("id"));
            Product removedProduct = DBHelper.find(Product.class, productId);
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            Customer customer = DBHelper.findCustomerByUsername(loggedInUser);
            CurrentPurchase basket = DBHelper.findBasketForCustomer(customer);
            Shop shop = DBHelper.findShopByName("PPS Groceries");
            List<Product> products = DBHelper.findProductsByShop(Product.class, shop);
            List<Product> contents = DBHelper.findContentsForBasket(basket);

            for(Product content: contents){
                if(content.getName().equals(removedProduct.getName())){
                    basket.reduceTotalInBasket(content);
                    DBHelper.saveOrUpdate(basket);
                    for(Product product: products){
                        if(product.getName().equals(removedProduct.getName())){
                            product.setQuantity(product.getQuantity() + content.getQuantity());
                            product.setAvailability(product.checkAvailability());
                            DBHelper.saveOrUpdate(product);
                        }
                    }
                    DBHelper.delete(content);
                }
            }

            String url = req.headers("referer");
            res.redirect(url);
            return null;
        }, new VelocityTemplateEngine());


        get("/basket/invoice", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            Customer customer = DBHelper.findCustomerByUsername(loggedInUser);
            CurrentPurchase basket = DBHelper.findBasketForCustomer(customer);
            List<Product> contents = DBHelper.findContentsForBasket(basket);
            double delivery = 0.00;
            if (basket.getTotal() < 40.00) {
                delivery = customer.calculateBaseDelivery();
            }
            double total = basket.getTotal() + delivery;
            model.put("user", loggedInUser);
            model.put("basket", basket);
            model.put("contents", contents);
            model.put("customer", customer);
            model.put("total", total);
            model.put("template", "templates/basket/invoice.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        post("/basket/purchase", (req, res) -> {
            String loggedInUser = LoginController.getLoggedInUsername(req, res);
            Customer customer = DBHelper.findCustomerByUsername(loggedInUser);
            CurrentPurchase basket = DBHelper.findBasketForCustomer(customer);
            List<Product> contents = DBHelper.findContentsForBasket(basket);
            basket.setContents(contents);

            double total = basket.getTotal();
            Shop shop = DBHelper.findShopByName("PPS Groceries");
            int day = LocalDate.now().getDayOfMonth();
            int month = LocalDate.now().getMonthValue();
            int year = LocalDate.now().getYear();
            GregorianCalendar purchaseDate = new GregorianCalendar(year, month, day);

            String strDeliveryDate = req.queryParams("deliveryDate");
            GregorianCalendar deliveryDate = DBHelper.formatStringToDate(strDeliveryDate);

            PreviousPurchase newPreviousPurchase = new PreviousPurchase(total, customer, purchaseDate, deliveryDate, shop);
            DBHelper.saveOrUpdate(newPreviousPurchase);

            for (Product basketProduct : contents) {

                String name = basketProduct.getName();
                double price = basketProduct.getPrice();
                int quantity = basketProduct.getQuantity();
                String description = basketProduct.getDescription();
                GregorianCalendar stockDate = basketProduct.getStockDate();
                Shop soldShop = basketProduct.getShop();

                if (basketProduct.getClass() == Food.class) {
                    Food stockFood = (Food) basketProduct;
                    FoodCategory foodCategory = stockFood.getCategory();
                    Food food = new Food(name, foodCategory, price, quantity, description, stockDate, soldShop);
                    DBHelper.saveOrUpdate(food);
                    DBHelper.addProductToPurchase(food, newPreviousPurchase);
                }
                else if (basketProduct.getClass() == Clothing.class) {
                    Clothing stockClothing = (Clothing) basketProduct;
                    ClothingCategory clothingCategory = stockClothing.getCategory();
                    Clothing clothing = new Clothing(name, clothingCategory, price, quantity, description, stockDate, soldShop);
                    DBHelper.saveOrUpdate(clothing);
                    DBHelper.addProductToPurchase(clothing, newPreviousPurchase);
                }
                else {
                    Health stockHealth = (Health) basketProduct;
                    HealthCategory healthCategory = stockHealth.getCategory();
                    Health health = new Health(name, healthCategory, price, quantity, description, stockDate, soldShop);
                    DBHelper.saveOrUpdate(health);
                    DBHelper.addProductToPurchase(health, newPreviousPurchase);
                }
            }

            DBHelper.saveOrUpdate(newPreviousPurchase);

            DBHelper.delete(basket);

            CurrentPurchase newBasket = new CurrentPurchase(0.00, customer);
            DBHelper.saveOrUpdate(newBasket);

            res.redirect("/home");
            return null;
        }, new VelocityTemplateEngine());

    }

}